package com.example.usermarslargestiamgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserMarsLargestImageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMarsLargestImageServiceApplication.class, args);
    }

}