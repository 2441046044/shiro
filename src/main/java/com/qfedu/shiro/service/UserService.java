package com.qfedu.shiro.service;

import com.qfedu.shiro.entity.User;

import java.util.List;

public interface UserService {

    public User findUserByName(String name);
    //获取登录用户权限信息的列表
    public List<String> findPermsByName(String name);

}
