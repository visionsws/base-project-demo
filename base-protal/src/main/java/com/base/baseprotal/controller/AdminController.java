package com.base.baseprotal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("admin")
@RefreshScope
public class AdminController {

    @Value("${user.name}")
    private String username;

    @Value("${user.id}")
    private String userid;

    @Value("${user.code}")
    private String usercode;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("testSleuth")
    public String testSleuth() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("base-admin");
        String path = String.format("http://%s:%s/subject/getSubject", serviceInstance.getHost(), serviceInstance.getPort());
        String result = restTemplate.getForObject(path, String.class);
        return String.format("%s from %s %s", result, serviceInstance.getHost(), serviceInstance.getPort());
    }

    @GetMapping("getNacosConfig")
    public String getNacosConfig() {
        System.out.println("username:"+username);
        System.out.println("userid:"+userid);
        System.out.println("usercode:"+usercode);
        return username;
    }
}
