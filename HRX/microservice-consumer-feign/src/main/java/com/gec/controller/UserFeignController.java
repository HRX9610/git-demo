package com.gec.controller;

import com.gec.client.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserFeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/findAllUsers")
    public List<String> findAllUsers(){
        return userFeignClient.findUserNameList();
    }

}
