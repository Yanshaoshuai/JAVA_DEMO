package com.javademo.mysql.mybatis;

import com.javademo.mysql.mybatis.mapper.UserMapper;
import com.javademo.mysql.mybatis.model.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisTest {
    private final UserMapper userMapper;
    private final static Logger LOG = LoggerFactory.getLogger(MybatisTest.class);

    @Autowired
    public MybatisTest(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Test
    public void testCRUD() {
        userMapper.insertUser(new User("少帅", 26));
        List<User> all = userMapper.getAll();
        LOG.info(all.toString());
        User user = userMapper.getUser(all.get(0).getId());
        LOG.info(user.toString());
        for (User userTemp : all) {
            userMapper.deleteUser(userTemp.getId());
        }
        all = userMapper.getAll();
        LOG.info(all.toString());
    }
}
