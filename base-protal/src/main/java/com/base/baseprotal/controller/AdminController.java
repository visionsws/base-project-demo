package com.base.baseprotal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("hello/{message}")
    public String hello(@PathVariable String message) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("base-admin");
        String path = String.format("http://%s:%s/subject/getSubject", serviceInstance.getHost(), serviceInstance.getPort());
        String result = restTemplate.getForObject(path, String.class);
        return String.format("%s from %s %s", result, serviceInstance.getHost(), serviceInstance.getPort());
    }
}
