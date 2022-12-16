package com.backend.stadiumservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.openfeign.storageService")
public class StadiumsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StadiumsServiceApplication.class, args);
    }
}
