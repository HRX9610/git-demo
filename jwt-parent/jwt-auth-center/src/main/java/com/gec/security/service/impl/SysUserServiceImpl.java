package com.gec.security.service.impl;

import com.gec.security.mapper.SysUserMapper;
import com.gec.security.pojo.SysUser;
import com.gec.security.pojo.SysUserExample;
import com.gec.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUser findUserByUsercode(String username) {
        System.out.println("账号（service） : " + username);
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsercodeEqualTo(username);
        List<SysUser> list = userMapper.selectByExample(example);
        if (list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
