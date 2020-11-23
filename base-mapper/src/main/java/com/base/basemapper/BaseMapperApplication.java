package com.base.basemapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.base.basemapper.mapper")
public class BaseMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseMapperApplication.class, args);
    }

}
