package com.springproject.auth.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableCaching
@EntityScan(basePackages = "com.springproject.auth.entities")
@EnableJpaRepositories(basePackages = "com.springproject.auth.dao")
@ComponentScan(basePackages = "com.springproject.auth")
public class Application {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }
}