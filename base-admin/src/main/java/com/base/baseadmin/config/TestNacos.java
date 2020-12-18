package com.base.baseadmin.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

public class TestNacos {

    public static void main(String[] args) throws NacosException, InterruptedException {
        String dataId = "base-admin-dev.yaml";
        String groupId = "DEFAULT_GROUP";
        String serverAddr = "192.168.243.33:8848";
        String namespace = "6d019736-88bd-44a3-b96a-e38ec6a2b906";
        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);
        properties.put("namespace",namespace);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String config = configService.getConfig(dataId, groupId, 5000);
        System.out.println(config);
        //监听配置文件
        configService.addListener(dataId, groupId, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            //当配置文件修改时会监听到并打印
            @Override
            public void receiveConfigInfo(String s) {
                System.out.println(s);
            }
        });

        while(true){
            Thread.sleep(2000);
        }


    }
}
