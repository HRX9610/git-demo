package com.web.content;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@MapperScan("/com.web.shopping.mapper")
public class AppContent {
    public static void main(String[] args) {

        SpringApplication.run(AppContent.class, args);
    }
}
