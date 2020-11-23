package com.base.baseadminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class BaseAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseAdminServerApplication.class, args);
    }

}
