package com.gec.web.service;

import com.gec.web.mapper.ItemsMapper;
import com.gec.web.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> queryItems() {
        return itemsMapper.selectByExample(null);
    }

    @Override
    public void addItems(Items items) {
        itemsMapper.insert(items);
    }
}
