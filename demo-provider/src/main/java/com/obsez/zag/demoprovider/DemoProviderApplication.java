package com.obsez.zag.demoprovider;

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
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix //允许监控数据上报 | http://app:port/actuator/hystrix.stream
public class DemoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProviderApplication.class, args);

        //final SpringApplication application = new SpringApplication(DemoProviderApplication.class);
        //application.setBannerMode(Banner.Mode.OFF);
        //application.setWebApplicationType(WebApplicationType.SERVLET);
        //application.run(args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
