package com.gec.elastisearch.service.impl;



import com.gec.elastisearch.document.EsItem;
import com.gec.elastisearch.repository.EsItemRepository;
import com.gec.elastisearch.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import java.util.Map;

@Service
public class ItemSearchServiceImpl implements ItemSearchService {

	@Autowired
	private EsItemRepository esItemRepository;
	
	@Override
	public Map search(Map searchMap) {
		Map map=new HashMap();

		Page<EsItem> page = esItemRepository.findByKeyword(searchMap.get("keywords").toString(),null);
		map.put("rows", page.getContent());
		System.out.println(page.getContent());
		return map;
	}

}
