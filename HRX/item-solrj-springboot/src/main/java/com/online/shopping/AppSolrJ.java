package com.online.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.online.shopping.mapper")
public class AppSolrJ {
    public static void main(String[] args) {
        SpringApplication.run(AppSolrJ.class,args);
    }
}
