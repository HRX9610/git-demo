package com.web.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.web.news.mapper")
public class AppQuery {
    public static void main(String[] args) {
        SpringApplication.run(AppQuery.class,args);
    }
}
