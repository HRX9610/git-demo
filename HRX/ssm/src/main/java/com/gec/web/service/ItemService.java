package com.gec.web.service;

import com.gec.web.pojo.Items;

import java.util.List;

public interface ItemService {

    public List<Items> queryItems();

    public void addItems(Items items);
}
