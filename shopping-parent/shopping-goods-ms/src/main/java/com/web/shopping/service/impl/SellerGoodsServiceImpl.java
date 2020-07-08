package com.web.shopping.service.impl;

import com.web.shopping.mapper.TbBrandMapper;
import com.web.shopping.pojo.TbBrand;
import com.web.shopping.service.SellerGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SellerGoodsServiceImpl implements SellerGoodsService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public void updateBrand(TbBrand tbBrand) {
         tbBrandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public void addBrand(TbBrand tbBrand) {
         tbBrandMapper.insert(tbBrand);
    }

    @Override
    public void deleteManyBrand(int[] ids) {
        for(long id: ids){
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<TbBrand> queryBrand() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public TbBrand findBrandById(long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Map> selectOptionList() {
        return tbBrandMapper.selectOptionList();
    }
}
