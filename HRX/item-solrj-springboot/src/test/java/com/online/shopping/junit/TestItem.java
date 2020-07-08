package com.online.shopping.junit;

import com.online.shopping.mapper.TbItemMapper;
import com.online.shopping.pojo.TbItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.util.List;

@SpringBootTest
public class TestItem {

    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private SolrTemplate solrTemplate;

    @Test
    public void testRemoveAll(){
        Query query = new SimpleQuery("*:*");
        solrTemplate.delete("collection1",query);
        solrTemplate.commit("collection1");
        System.out.println("清空数据完成");
    }

    @Test
    public void testAdd(){
        TbItem item = new TbItem();
        item.setId(10L);
        item.setTitle("康师傅牛肉面");
        item.setPrice(50D);
        item.setImage("http://localhost:8080/xxx.jpg");

        solrTemplate.saveBean("collection1",item);
        solrTemplate.commit("collection1");

        System.out.println("添加数据完成");
    }

    @Test
    public void testImportData(){
        List<TbItem> list = tbItemMapper.selectByExample(null);
        solrTemplate.saveBeans("collection1",list);
        solrTemplate.commit("collection1");
        System.out.println("导入数据完成");
    }

    @Test
    public void testQuery(){
        Query query = new SimpleQuery("*:*");

        Criteria criteria = new Criteria("item_title").endsWith("手机");
        query.setRows(100);

        query.addCriteria(criteria);
        ScoredPage<TbItem> scoredPage = solrTemplate.query("collection1",query,TbItem.class);
        List<TbItem> list = scoredPage.getContent();
        for (TbItem tbItem: list) {
            System.out.println(tbItem.getTitle()+","+tbItem.getPrice()+","+tbItem.getImage());
        }
    }
}
