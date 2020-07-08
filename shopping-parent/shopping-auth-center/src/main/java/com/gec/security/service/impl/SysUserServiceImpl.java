package com.gec.security.service.impl;

import com.gec.security.service.SysUserService;
import com.web.shopping.mapper.TbSellerMapper;
import com.web.shopping.pojo.TbSeller;
import com.web.shopping.pojo.TbSellerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private TbSellerMapper tbSellerMapper;

    @Override
    public TbSeller findUserByTbSellerId(String username) {
        System.out.println("账号（service） : " + username);
        TbSellerExample example = new TbSellerExample();
        TbSellerExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(username);
        List<TbSeller> list = tbSellerMapper.selectByExample(example);
        if (list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
