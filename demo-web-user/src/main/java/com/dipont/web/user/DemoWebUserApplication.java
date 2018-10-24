package com.dipont.web.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages={"com.dipont.service.user.service", "com.dipont.service.user.service.impl", "com.dipont.service.user.dao", "com.dipont.web.user"})
@EnableJpaRepositories(basePackages = "com.dipont.service.user.dao")
@EntityScan(basePackages = "com.dipont.api.entity")
@SpringBootApplication
@ServletComponentScan
public class DemoWebUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebUserApplication.class, args);
    }
}
