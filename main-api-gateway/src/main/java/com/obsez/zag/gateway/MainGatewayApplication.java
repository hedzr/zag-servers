package com.obsez.zag.gateway;

import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
//@EnableTurbine    //not used.
//@EnableZuulServer //not used.
public class MainGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainGatewayApplication.class, args);

//        boolean cloudEnvironment = new StandardEnvironment().acceptsProfiles("cloud");
//        new SpringApplicationBuilder(MainGatewayApplication.class).web(!cloudEnvironment).run(args);
    }

    //@Bean
    //public ZuulFilter VWZF(){
    //    return new VersioningWeightFilter();
    //}

}
