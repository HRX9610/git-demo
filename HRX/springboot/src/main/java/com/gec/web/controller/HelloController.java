package com.gec.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/findUsers")
    public List<String> findUsers(){
        List<String> names = new ArrayList<>();
        names.add("hello");
        names.add("world");
        names.add("sleep");
        return names;
   }
}
