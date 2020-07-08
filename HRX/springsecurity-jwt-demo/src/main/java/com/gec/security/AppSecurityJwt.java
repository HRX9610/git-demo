package com.gec.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gec.security.mapper")
public class AppSecurityJwt {
    public static void main(String[] args) {
        SpringApplication.run(AppSecurityJwt.class,args);
    }
}
