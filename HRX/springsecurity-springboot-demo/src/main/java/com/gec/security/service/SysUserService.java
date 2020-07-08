package com.gec.security.service;

import com.gec.security.mapper.SysUserMapper;
import com.gec.security.pojo.SysUser;
import com.gec.security.pojo.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("用户名 = "+ username);

        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsercodeEqualTo(username);
        List<SysUser> list = userMapper.selectByExample(example);
        if(list!=null && list.size()==0){
            throw new UsernameNotFoundException("账号不存在");
        }
        return list.get(0);
    }
}
