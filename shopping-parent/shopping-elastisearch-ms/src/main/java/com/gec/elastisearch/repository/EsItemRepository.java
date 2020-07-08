package com.gec.elastisearch.repository;


import com.gec.elastisearch.document.EsItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface EsItemRepository extends ElasticsearchRepository<EsItem,Long> {

   // public Page<EsItem> findByTitleAndBrand(String title, String brand, Pageable pageable);
    /**
     *
     * GET /shoppingindex/items/_search
     * {
     *   "query": {
     *     "multi_match": {
     *       "query": "小米",
     *       "fields": ["title","brand","category"]
     *     }
     *   }
     * }
     *搞成一行,外围的query不要
     *
     * {"multi_match": {"query": "小米","fields": ["title","brand","category"]}}
     *
     */
    @Query("{\"multi_match\": {\"query\": \"?0\",\"fields\": [\"title\",\"brand\"]}}")
    public Page<EsItem> findByKeyword(String keyword, Pageable pageable);
}









