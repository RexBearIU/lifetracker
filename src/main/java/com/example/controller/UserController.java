package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
// import com.example.mapper.UserMapper;
import com.example.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   UserMapper userMapper;

   @GetMapping("/get")
   public String index() {
      
      User user = userMapper.selectById(9);
      System.out.println(user);
      return "user="+user;
   }

   // @Autowired
   // UserServiceImpl userServiceImpl;

   // @GetMapping("/get")
   // public String index() {
      
   //    User user = userServiceImpl.find(8);

   //    return "user="+user;
   // }
}


