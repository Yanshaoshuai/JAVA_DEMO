package com.javademo.shiro.springboot.service;

import com.javademo.shiro.springboot.entity.User;

import java.util.List;

public interface UserService {
    //用户登录
    User getUserInfoByName(String name);

    List<String> getRoleNames(String name);

    List<String> getPermissionsInfo(List<String> roleNames);
}
