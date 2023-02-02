package com.example.lifetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bean.User;
import com.example.mapper.UserMapper;

import org.junit.jupiter.api.Test;



@SpringBootTest(classes = LifetrackerApplication.class)
class LifetrackerApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void secondTest() {
		User user = new User(1,"jacky",111.0);
		userMapper.insert(user);	
	}

}
