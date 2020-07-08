package org.web.auction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.web.auction.mapper")  //扫描mapper基础包
public class AppAuction {
    public static void main(String[] args) {
        SpringApplication.run(AppAuction.class,args);
    }
}
