package com.omline.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.omline.shopping.mapper")
public class AppElasit {
    public static void main(String[] args) {
        SpringApplication.run(AppElasit.class,args);
    }
}
