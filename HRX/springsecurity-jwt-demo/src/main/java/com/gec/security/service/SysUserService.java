package com.gec.security.service;

import com.gec.security.pojo.SysUser;

public interface SysUserService {

    public SysUser findUserByUsercode(String usercode);
}
