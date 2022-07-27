package com.javademo.mysql.mybatis.mapper;

import com.javademo.mysql.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAll();

    User getUser(Long id);

    Long insertUser(User user);

    Long updateUser(User user);

    Long deleteUser(Long id);
}

