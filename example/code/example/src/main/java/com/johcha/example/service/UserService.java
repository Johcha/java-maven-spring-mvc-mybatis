package com.johcha.example.service;

import com.johcha.example.model.User;

import java.util.List;

/**
 * Created by Johcha on 2016/11/15 0015.
 */
public interface UserService {

    User getUserById(String id);

    List<User> getUsers();

    int insert(User userInfo);
}