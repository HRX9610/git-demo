package com.gec.security.service;

import com.web.shopping.pojo.TbSeller;

public interface SysUserService {

    public TbSeller findUserByTbSellerId(String usercode);
}
