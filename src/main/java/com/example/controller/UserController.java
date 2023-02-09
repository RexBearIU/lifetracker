package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;
import com.example.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

   @Autowired
   UserService userService;

   @GetMapping("/get")
   public String getUserData(int id) {
      
      User user = userService.getUser(id);
      System.out.println(user);
      return user.toString();
   }
   @GetMapping("/login")
   public String loginUser(Model model) {
      
      User user = userService.getUser(15);
      model.addAttribute("user", user);
      return "login";
   }
   
}


