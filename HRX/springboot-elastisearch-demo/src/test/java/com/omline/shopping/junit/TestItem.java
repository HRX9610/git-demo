package com.omline.shopping.junit;

import com.omline.shopping.document.EsItem;
import com.omline.shopping.mapper.TbItemMapper;
import com.omline.shopping.pojo.TbItem;
import com.omline.shopping.repository.EsItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class TestItem {
    @Autowired
    private EsItemRepository esItemRepository;
    @Autowired
    private TbItemMapper itemMapper;
    @Test
    public void testInit(){
        List<TbItem> list = itemMapper.selectByExample(null);
        for(TbItem item :list){
            EsItem esItem = new EsItem();
            esItem.setId(item.getId());
            esItem.setTitle(item.getTitle());
            esItem.setBrand(item.getBrand());
            esItem.setCategory(item.getCategory());
            esItem.setGoodsId(item.getGoodsId());
            esItem.setImage(item.getImage());
            esItem.setPrice(item.getPrice());
            esItem.setSeller(item.getSeller());
            esItemRepository.save(esItem);
        }
        System.out.println("导入数据完成");
    }



    @Test
    public void testQueryAll(){
        Iterator<EsItem> iterator=esItemRepository.findAll().iterator();
        while(iterator.hasNext()){
            EsItem esItem=iterator.next();
            System.out.println(esItem);
        }
    }

    @Test
    public void testQueryTitleAndBrand(){
       Page<EsItem> page = esItemRepository.findByTitleAndBrand("荣耀","华为",null);
        for (EsItem item:page.getContent()){
            System.out.println(item);
        }
    }
    @Test
    public void testQueryKeyword(){
       Page<EsItem> page = esItemRepository.findByKeyword("小米",null);
       //iter+Tab

       for(EsItem item:page.getContent()){
           System.out.println(item);
       }
    }
}








