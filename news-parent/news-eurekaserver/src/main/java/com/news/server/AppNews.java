package com.news.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AppNews {
    public static void main(String[] args) {
        SpringApplication.run(AppNews.class,args);
    }
}
