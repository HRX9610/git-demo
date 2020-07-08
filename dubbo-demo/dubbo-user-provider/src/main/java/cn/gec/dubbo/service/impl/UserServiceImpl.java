package cn.gec.dubbo.service.impl;

import cn.gec.dubbo.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getHello(String name) {
        return "hello, goodafternoon, "+ name;
    }
}
