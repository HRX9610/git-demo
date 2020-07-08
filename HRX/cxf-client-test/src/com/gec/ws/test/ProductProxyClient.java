package com.gec.ws.test;

import com.gec.ws.pojo.Product;
import com.gec.ws.service.ProductService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import java.util.List;

public class ProductProxyClient {

    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ProductService.class);
        factory.setAddress("http://localhost:8080/services/productService");
        ProductService productService = (ProductService)factory.create();

        List<Product> list = productService.findAllProducts();
        for (Product product:list ) {
            System.out.println(product.getId()+","+product.getName()+","+product.getPrice()+","+product.getLocation());
        }
    }

}
