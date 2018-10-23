package com.dipont.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DemoWebCoreApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoWebCoreApplication.class, args);
    }
}
