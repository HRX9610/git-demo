package com.gec.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@FeignClient(value = "service-provider",fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/findUserList",method = RequestMethod.GET)
    public List<String> findUserNameList();
}

@Component
class UserFeignClientFallback implements UserFeignClient{

    @Override
    public List<String> findUserNameList() {
        List<String> list = new ArrayList<>();
        list.add("服务故障，启动备胎计划");
        return list;
    }
}
