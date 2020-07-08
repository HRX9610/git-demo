package com.gec.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

public class TestSolrJ {

    @Test
    public void testAdd() throws Exception {
        SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");

        SolrInputDocument document = new SolrInputDocument();
        document.setField("id","item0003");
        document.setField("item_title","荣耀v30 pro");
        document.setField("item_price",3500);
        document.setField("item_desc","very good");

        solrServer.add(document);
        solrServer.commit();

        System.out.println("导入solr库成功");
    }

    @Test
    public void testQuery() throws SolrServerException {
        SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");

        SolrQuery query = new SolrQuery();
        //query.set("q","*:*");
        query.set("q","item_title:荣耀");
        query.set("sort","item_price desc");
        query.setStart(0);
        query.setRows(100);

        QueryResponse response = solrServer.query(query);
        SolrDocumentList list = response.getResults();

        System.out.println("当前记录数：" + list.getNumFound());

        for (SolrDocument document : list) {
            System.out.println(document.get("id"));
            System.out.println(document.get("item_title"));
            System.out.println(document.get("item_price"));
            System.out.println(document.get("item_desc"));

            System.out.println("---------------------------");
        }

    }

}