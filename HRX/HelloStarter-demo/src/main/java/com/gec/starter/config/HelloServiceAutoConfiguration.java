package com.gec.starter.config;

import com.gec.starter.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//自动配置类
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(HelloService.class) //如果当前工程的类路径之下存在HelloService.class, 自动启动配置类
public class HelloServiceAutoConfiguration {


     @Autowired
    HelloProperties helloProperties;


     @Bean
     HelloService helloService() {  // DruidDataSource
        HelloService helloService = new HelloService();
        helloService.setName(helloProperties.getName());
        helloService.setMsg(helloProperties.getMsg());
        return helloService;
     }
}

