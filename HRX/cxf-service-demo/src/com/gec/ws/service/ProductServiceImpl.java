package com.gec.ws.service;

import com.alibaba.fastjson.JSON;
import com.gec.ws.pojo.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    @Override
    public List<Product> findAllProducts() {
        List<Product> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(new Product(i,"华为Mate30 "+i,4000D,"中国深圳"));
        }
        return list;
    }

    @Override
    public String findProductByJson() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1,"华为Mate30 ",4000D,"中国深圳"));
        list.add(new Product(2,"小米x39 ",4000D,"中国深圳"));
        list.add(new Product(3,"荣耀p70 ",4000D,"中国深圳"));
        String json = JSON.toJSONString(list);
        return json;
    }
}
