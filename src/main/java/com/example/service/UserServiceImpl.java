package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
	private UserMapper userMapper;

    @Override
    public User add(User user) {
        
        User user2 = user;
        return user2;
    }

    @Override
    public User find(int id) {
        
        User user = userMapper.selectById(id);
        
        return user;
    }

    
}