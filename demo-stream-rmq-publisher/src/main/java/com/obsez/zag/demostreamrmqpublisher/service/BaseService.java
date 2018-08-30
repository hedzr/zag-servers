package com.obsez.zag.demostreamrmqpublisher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class BaseService {

    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private DiscoveryClient discoveryClient;

    public String getAppName() {
        return appName;
    }

    public ServiceInstance getThisInstanceInfo() {
        List<ServiceInstance> x = discoveryClient.getInstances(getAppName());
        return x != null && x.size() > 0 ? x.get(0) : null;
    }

//    @Value("${eureka.instance.instance-id}")
//    String instid;
//
//    public String getInstanceId() {
//        return instid;
//    }
}
