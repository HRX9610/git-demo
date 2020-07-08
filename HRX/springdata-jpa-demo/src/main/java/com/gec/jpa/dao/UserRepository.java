package com.gec.jpa.dao;

import com.gec.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //命 名 查 询：findBy+属性名+查询方式
    public List<User> findByUserNameLike(String username);

}

