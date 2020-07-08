package com.web.shopping.service;

import com.web.shopping.pojo.TbBrand;

import java.util.List;
import java.util.Map;

public interface SellerGoodsService {

    public void updateBrand(TbBrand tbBrand);

    public void addBrand(TbBrand tbBrand);

    public void deleteManyBrand(int[] ids);

    public List<TbBrand> queryBrand();

    public TbBrand findBrandById(long id);

    public List<Map> selectOptionList();
}
