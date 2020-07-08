package com.gec.jpa.service;

import com.gec.jpa.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
    public Page<User> findByPage(int pageNum, int pageSize);
}
