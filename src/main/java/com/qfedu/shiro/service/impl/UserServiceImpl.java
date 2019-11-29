package com.qfedu.shiro.service.impl;

import com.qfedu.shiro.dao.UserDao;
import com.qfedu.shiro.entity.User;
import com.qfedu.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

//用在类上设置缓存名称
@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public User findUserByName(String name) {
        return userDao.findByName(name);
    }


    //作用在方法上，缓存方法的缓存值
    //@Cacheable(value = "user",key = "")
    @Override
    @Cacheable(key = "'perms'.concat(#name)")//该类已配置 缓存cacheNames:user
    public List<String> findPermsByName(String name) {
        return userDao.findPermsByName(name);
    }
}
