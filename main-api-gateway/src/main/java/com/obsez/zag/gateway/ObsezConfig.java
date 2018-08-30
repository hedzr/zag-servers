package com.obsez.zag.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "obsez")
public class ObsezConfig {
    private Map<String/*serviceId*/, Map<String/*version*/, Integer/*weight*/>> lb = new LinkedHashMap<>();

    public Map<String, Map<String,Integer>> getLb() {
        return lb;
    }

    public void setLb(Map<String, Map<String,Integer>> lb) {
        this.lb = lb;
    }
}
