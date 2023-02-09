package com.example.service;


import com.example.bean.User;


public interface UserService {
    
    /**
     * @return user
     */
    public boolean createUser(User user);
    
    public User getUser(int id);

    public boolean putUser(User user);

    public boolean delectUser(int id); 
        
}
