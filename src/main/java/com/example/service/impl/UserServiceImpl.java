package com.example.service.impl;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.AuthorityUtils;

import com.example.bean.LifeUser;
import com.example.mapper.UserMapper;
import com.example.service.UserService;

import jakarta.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Resource
	private UserMapper userMapper;

    @Override
    public boolean createUser(LifeUser user) {

        int insert = userMapper.insert(user);
      
    
        if (insert<1){
            return false;
        };
        return true;
    }

    @Override
    public LifeUser getUser(Integer id) {
        
        LifeUser user = userMapper.selectById(id);
        
        return user;
    }

    @Override
    public boolean putUser(LifeUser user) {
        
        int update = userMapper.update(user);
        
        if (update<1){
            return false;
        };
        return true;
    }

    @Override
    public boolean delectUser(Integer id) {
        
        int delectById = userMapper.delectById(id);

        if (delectById<1){
            return false;
        };
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        LifeUser user = userMapper.selectByEmail(Email);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        // return new User(username,user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return new User(user.getName(),"$2a$12$Q0fu74idNx4IOMUPbN3sNOsMxAfJIfC.UatH/orYKJiMJrrN4.T2u", AuthorityUtils.commaSeparatedStringToAuthorityList("user,admin"));
    }

    
    
    
}