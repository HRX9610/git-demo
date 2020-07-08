package cn.web.items.service;

import cn.web.items.pojo.Items;

import java.util.List;

public interface ItemService {

    public List<Items> findAllItems();
    public Items findItemsById(int id);
    public void addItems(Items items);
    public void updateItems(Items items);
    public void deleteItems(int id);
}
