package cn.gec.dubbo.controller;

import cn.gec.dubbo.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference
    private UserService userService;

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable String name){
        return userService.getHello(name);
    }
}
