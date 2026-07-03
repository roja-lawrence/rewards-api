package com.roja.rewardsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
public class RewardsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RewardsApiApplication.class, args);
    }

}
