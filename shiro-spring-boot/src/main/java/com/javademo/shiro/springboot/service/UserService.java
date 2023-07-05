package com.javademo.shiro.springboot.service;

import com.javademo.shiro.springboot.entity.User;

public interface UserService {
    //用户登录
    User getUserInfoByName(String name);
}
