package com.gec.test;

import com.gec.starter.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestStarter {


     @Autowired
     private HelloService helloService;

     @Test
     public void testHelloService() {
              String msg = helloService.sayHello();
            System.out.println(msg);
     }
}

