package com.example.lifetracker;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.bean.LifeUser;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
// import com.example.service.impl.UserServiceImpl;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Test;



@SpringBootTest(classes = LifetrackerApplication.class)
class LifetrackerApplicationTests {

	@Resource
	private UserMapper userMapper;

	@Resource
	private UserService userService;

	@Test
	public void userMapperInsertTest() {
		LifeUser user = new LifeUser(1,"ad",55.2);
		userMapper.insert(user);	
	}

	@Test
	public void userMapperSelectByIdTest() {

		LifeUser user = userMapper.selectById(25);
		System.out.println(user);

	}
	@Test
	public void userMapperSelectByNameTest() {

		LifeUser user = userMapper.selectByName("dadad");
		System.out.println(user);

	}
	@Test
    public void passwordEncodertest(){

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        
        //encode password
        String password = encoder.encode("12");
        System.out.println("------------"+password);

        //Determine whether the original characters match the content after encryption
        boolean result = encoder.matches("123",password);
        System.out.println("============="+result);
    }
	@Test
	public void userServiceCreateTest() {
		LifeUser user = new LifeUser(1,"caca",1263.5);
		boolean createUser = userService.createUser(user);;	
		System.out.println(createUser);
	}
	@Test
	public void userServiceGetTest() {
		
		LifeUser user = userService.getUser(25);;
		System.out.println(user);
	}

	@Test
	public void userServicePutTest() {
		LifeUser user = new LifeUser(50,"dadad",1263.5);
		boolean putUser = userService.putUser(user);;	
		System.out.println(putUser);
	}
	@Test
	public void userServiceDelectTest() {
		
		boolean delectUser = userService.delectUser(14);
		System.out.println(delectUser);
	}

}


