package com.javademo.shiro.springboot.service.impl;

import com.javademo.shiro.springboot.entity.User;
import com.javademo.shiro.springboot.mapper.UserMapper;
import com.javademo.shiro.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserInfoByName(String name) {
        return userMapper.getUserByName(name);
    }
}
