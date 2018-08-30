package com.obsez.zag.service.swuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.obsez.zag", "com.obsez.zag.common"})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix //允许监控数据上报 | http://app:port/actuator/hystrix.stream
//@EnableSwagger2
public class SwUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwUserApplication.class, args);
    }
}
