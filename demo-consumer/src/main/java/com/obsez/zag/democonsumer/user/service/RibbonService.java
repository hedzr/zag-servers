package com.obsez.zag.democonsumer.user.service;

import com.obsez.zag.common.service.EndPointBuilder;
import com.obsez.zag.democonsumer.user.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.simple.SimpleDiscoveryProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class RibbonService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    //private static final Logger logger = LoggerFactory.getLogger(RibbonService.class);

    @Autowired
    private RestTemplate restTemplate;

    //    @Value("normal")
//    private String normal; // 注入普通字符串
//
//    @Value("#{systemProperties['os.name']}")
//    private String systemPropertiesName; // 注入操作系统属性
//
//    @Value("#{ T(java.lang.Math).random() * 100.0 }")
//    private double randomNumber; //注入表达式结果
//
//    @Value("#{beanInject.another}")
//    private String fromAnotherBean; // 注入其他Bean属性：注入beanInject对象的属性another，类具体定义见下面
//
//    @Value("classpath:com/hry/spring/configinject/config.txt")
//    private Resource resourceFile; // 注入文件资源
//
//    @Value("http://www.baidu.com")
//    private Resource testUrl; // 注入URL资源

    @Value("${spring.application.name}")
    private String appName;

    @Value("${obsez.depends.demo-provider}")
    private String providerServiceId;

    //@Value("${info.api-gateway}")
    //private String apigw;

    @Value("${demo.title}")
    private String demoTitle;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findById(Long id) {
        //String requestUri = String.format("http://%s/%s/user/%s", apigw, providerServiceId, id);
        //String requestUri = endpointBuilder.build(providerServiceId, String.format("/user/%s", id));
        String requestUri = EndPointBuilder.get().withService(providerServiceId).withContextPath("/user/%s", id).build();
        logger.info("requestUri = {}", requestUri);
        User user = this.restTemplate.getForObject(requestUri, User.class);
        if (user != null) user.setDesc(demoTitle);
        return user;
    }

    public User findByIdFallback(Long id) {
        logger.info("异常发生，进入 findByIdFallback 方法，接收的参数：id = {}", id);
        User user = new User();
        user.setId(-1L);
        user.setUsername("fake username");
        user.setAge(0);
        user.setDesc(demoTitle);
        return user;
    }

    //    public List getServerInfo() {
    //        return this.restTemplate.getForObject(String.format("http://%s/user/instance-info", providerServiceId), List.class);
    //    }
    @HystrixCommand(fallbackMethod = "getServerInfoFallback")
    public ServiceInstance getServerInfo() {
        String requestUri = EndPointBuilder.get().withService(providerServiceId).withContextPath("/user/instance-info").build();
        logger.info("requestUri = {}", requestUri);
        return this.restTemplate.getForObject(requestUri,
                SimpleDiscoveryProperties.SimpleServiceInstance.class);
    }

    public ServiceInstance getServerInfoFallback() {
        logger.info("异常发生，进入 getServerInfoFallback 方法，接收的参数：()");
        return null;
    }

    @HystrixCommand(fallbackMethod = "getServerInfoByGWFallback")
    public ServiceInstance getServerInfoByGW() {
        String requestUri = EndPointBuilder.get().withLocalGateway(true).withService(providerServiceId).withContextPath("/user/instance-info").build();
        logger.info("requestUri = {}", requestUri);
        return this.restTemplate.getForObject(requestUri,
                SimpleDiscoveryProperties.SimpleServiceInstance.class);
    }

    public ServiceInstance getServerInfoByGWFallback() {
        logger.info("异常发生，进入 getServerInfoFallback 方法，接收的参数：()");
        return null;
    }
}
