package com.example.service;


import com.example.bean.LifeUser;


public interface UserService {
    
    /**
     * @return user
     */
    public boolean createUser(LifeUser user);
    
    public LifeUser getUser(String email);

    public boolean putUser(LifeUser user);

    public boolean delectUser(Integer id); 
        
}
