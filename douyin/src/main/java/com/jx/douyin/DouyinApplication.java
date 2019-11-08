package com.jx.douyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DouyinApplication {

    public static void main(String[] args) {
        SpringApplication.run(DouyinApplication.class, args);
    }

}
