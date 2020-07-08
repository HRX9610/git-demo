package com.gec.ws.pojo;

import java.io.Serializable;

public class Product  implements Serializable {

    private Integer id;
    private String name;
    private Double price;
    private String location;

    public Product() {
    }

    public Product(Integer id, String name, Double price, String location) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
