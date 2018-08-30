package com.obsez.zag.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.obsez.zag", "com.obsez.zag.common"})
@EnableEurekaServer
@EnableDiscoveryClient
public class MainEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainEurekaServerApplication.class, args);
    }
}
