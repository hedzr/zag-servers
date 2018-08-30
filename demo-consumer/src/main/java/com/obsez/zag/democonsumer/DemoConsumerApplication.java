package com.obsez.zag.democonsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.obsez.zag", "com.obsez.zag.common"})
//@PropertySource(ignoreResourceNotFound = true, value = {
//        "classpath:jdbc-${spring.profiles.active}.properties",
//        "classpath:swagger.properties",
//        "classpath:swagger.yml",
//        "classpath:application.properties",
//        "classpath:application.yml",
//        "classpath:application-${spring.profiles.active}.properties",
//        "classpath:application-${spring.profiles.active}.yml",
//})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix //允许监控数据上报 | http://app:port/actuator/hystrix.stream
//@EnableSwagger2
public class DemoConsumerApplication {

    /**
     * 实例化RestTemplate，通过@LoadBalanced注解开启均衡负载能力.
     *
     * @return restTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoConsumerApplication.class, args);
    }
}
