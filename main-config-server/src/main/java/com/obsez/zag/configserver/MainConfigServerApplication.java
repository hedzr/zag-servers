package com.obsez.zag.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.obsez.zag", "com.obsez.zag.common"})
@EnableConfigServer
@EnableEurekaClient
public class MainConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainConfigServerApplication.class, args);
    }
}
