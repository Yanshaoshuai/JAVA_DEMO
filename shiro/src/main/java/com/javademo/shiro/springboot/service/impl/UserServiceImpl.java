package com.javademo.shiro.springboot.service.impl;

import com.javademo.shiro.springboot.entity.User;
import com.javademo.shiro.springboot.mapper.UserMapper;
import com.javademo.shiro.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<String> getRoleNames(String name) {
        return userMapper.getRoleNamesByUserName(name);
    }

    @Override
    public List<String> getPermissionsInfo(List<String> roleNames) {
        return userMapper.getPermissionsByRoleNames(roleNames);
    }
}
