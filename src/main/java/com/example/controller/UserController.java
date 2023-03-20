package com.example.controller;

import java.security.Principal;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.bean.LifeUser;
import com.example.service.UserService;

import jakarta.annotation.Resource;


@Controller
@RequestMapping("/user")
public class UserController {

   @Resource
   UserService userService;
   
   @Resource
	private PasswordEncoder passwordEncoder;

   @RequestMapping("/get")
   public String getUserData(Model model, Principal principal) {
      // System.out.println(principal);
      LifeUser user = userService.getUser(principal.getName());
      model.addAttribute("user", user);
      return "index";
   }
   @RequestMapping("/login")
   public String login(Model model) {
      LifeUser lifeUser = new LifeUser();
      model.addAttribute("lifeUser", lifeUser);
      return "login";
   }
   @RequestMapping("/signup")
   public String signUp(@ModelAttribute(value = "LifeUser") LifeUser lifeUser) throws Exception {
      lifeUser.setPassword(passwordEncoder.encode( lifeUser.getPassword()));
      boolean createUser = userService.createUser(lifeUser);
      System.out.println(createUser);
      // if (createUser==false) {
      //    throw new Exception("This email has been used");
      // }
      return "success";
   }
   // @GetMapping("/success")
   // public String logout() {
   //    return "logout";
      
   // }
}


