package com.gec.ws.test;

import com.gec.ws.pojo.Product;
import com.gec.ws.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProductClient {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = (ProductService)context.getBean("productService");
        List<Product> list = productService.findAllProducts();
        for (Product product:list ) {
            System.out.println(product.getId()+","+product.getName()+","+product.getPrice()+","+product.getLocation());
        }
    }
}
