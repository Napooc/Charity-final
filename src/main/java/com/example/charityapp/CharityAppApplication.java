package com.example.charityapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.example.charityapp.controllers",
    "com.example.charityapp.service",
    "com.example.charityapp.config",
    "com.example.charityapp.controller"
})
@EntityScan("com.example.charityapp.model")
@EnableJpaRepositories("com.example.charityapp.repository")
public class CharityAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharityAppApplication.class, args);
    }

}
