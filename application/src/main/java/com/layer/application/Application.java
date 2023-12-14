package com.layer.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.layer.customer","com.layer.common", "com.layer.basket","com.layer.product", "com.layer.application"})
@ComponentScan(basePackages = {"com.layer.customer","com.layer.common", "com.layer.basket","com.layer.product", "com.layer.application"})
@EntityScan(basePackages = {"com.layer.customer","com.layer.common", "com.layer.basket","com.layer.product", "com.layer.application"})
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
