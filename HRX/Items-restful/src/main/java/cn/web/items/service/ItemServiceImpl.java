package cn.web.items.service;

import cn.web.items.mapper.ItemsMapper;
import cn.web.items.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> findAllItems() {
        return itemsMapper.selectByExample(null);
    }

    @Override
    public Items findItemsById(int id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addItems(Items items) {
        itemsMapper.insert(items);
    }

    @Override
    public void updateItems(Items items) {
        itemsMapper.updateByPrimaryKey(items);
    }

    @Override
    public void deleteItems(int id) {
         itemsMapper.deleteByPrimaryKey(id);
    }
}
