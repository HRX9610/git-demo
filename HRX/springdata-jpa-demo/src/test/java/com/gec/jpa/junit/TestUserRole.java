package com.gec.jpa.junit;

import com.gec.jpa.dao.SysRoleRepository;
import com.gec.jpa.dao.SysUserRepository;
import com.gec.jpa.entity.SysRole;
import com.gec.jpa.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@SpringBootTest
public class TestUserRole {

    @Resource
    private SysUserRepository sysUserRepository;
    @Resource
    private SysRoleRepository sysRoleRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAdd(){
        SysRole role = new SysRole();
        role.setName("emp");

        SysUser user = new SysUser();
        user.setUserCode("项羽");
        user.setPassword("9999");

        role.getUsers().add(user);
        user.getRoles().add(role);

        sysRoleRepository.save(role);
        sysUserRepository.save(user);

    }
}
