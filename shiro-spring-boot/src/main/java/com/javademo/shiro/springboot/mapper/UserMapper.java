package com.javademo.shiro.springboot.mapper;

import com.javademo.shiro.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUserByName(String name);
    List<String> getRoleNamesByUserName(String name);
    List<String> getPermissionsByRoleNames(List<String> roleNames);
}
