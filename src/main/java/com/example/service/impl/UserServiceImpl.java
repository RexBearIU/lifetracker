package com.example.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;

import jakarta.annotation.Resource;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserService {

    @Resource
	private UserMapper userMapper;

    @Override
    public boolean createUser(User user) {

        int insert = userMapper.insert(user);
      
    
        if (insert<1){
            return false;
        };
        return true;
    }

    @Override
    public User getUser(int id) {
        
        User user = userMapper.selectById(id);
        
        return user;
    }

    @Override
    public boolean putUser(User user) {
        
        int update = userMapper.update(user);

        if (update<1){
            return false;
        };
        return true;
    }

    @Override
    public boolean delectUser(int id) {
        
        int delectById = userMapper.delectById(id);

        if (delectById<1){
            return false;
        };
        return true;
    }

    
    
}