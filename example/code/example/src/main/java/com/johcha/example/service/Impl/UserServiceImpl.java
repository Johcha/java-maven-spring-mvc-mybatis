package com.johcha.example.service.Impl;

import com.johcha.example.dao.UserMapper;
import com.johcha.example.model.User;
import com.johcha.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Johcha on 2016/11/15 0015.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.selectAll();
    }

    @Override
    public int insert(User userInfo) {

        int result = userMapper.insert(userInfo);

        System.out.println(result);
        return result;
    }

}