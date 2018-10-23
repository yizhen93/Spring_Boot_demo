package com.dipont.web.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Service;

@ComponentScan(basePackages={"com.dipont.service.user.service", "com.dipont.service.user.service.impl", "com.dipont.service.user.dao", "com.dipont.web.user"})
@SpringBootApplication
@ServletComponentScan
public class DemoWebUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebUserApplication.class, args);
    }
}
