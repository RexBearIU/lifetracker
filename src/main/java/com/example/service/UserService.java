package com.example.service;

import org.springframework.stereotype.Service;

import com.example.bean.User;

@Service
public interface UserService {
    
    /**
     * @return
     */
    public User add(User user);
    
    public User find(int id);
        
}
