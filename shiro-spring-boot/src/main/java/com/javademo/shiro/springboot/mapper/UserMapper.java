package com.javademo.shiro.springboot.mapper;

import com.javademo.shiro.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByName(String name);
}
