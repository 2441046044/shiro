package com.qfedu.shiro.dao;

import com.qfedu.shiro.entity.MenuInfo;
import com.qfedu.shiro.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao{

    //根据用户id获取菜单信息
    public List<MenuInfo> findMenuInfo(Integer uid);

    //
    public User findByName(String name);

    //获取登录用户权限信息的列表
    public List<String> findPermsByName(String name);

}
