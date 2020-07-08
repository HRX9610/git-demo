package com.gec.ws.service;

import com.gec.ws.pojo.Product;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductService {
    public List<Product> findAllProducts();
}
