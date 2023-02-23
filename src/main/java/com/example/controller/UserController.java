package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.bean.LifeUser;
import com.example.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

   @Autowired
   UserService userService;

   @GetMapping("/get")
   public String getUserData(Model model) {
      
      LifeUser user = userService.getUser(25);
      model.addAttribute("user", user);
      return "index";
   }
   @RequestMapping("/login")
   public String login() {
      
      return "login";
   }
   
}


