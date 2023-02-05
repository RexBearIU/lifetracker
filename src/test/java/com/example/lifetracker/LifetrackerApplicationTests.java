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
		User user = new User(1,"ad",55.2);
		userMapper.insert(user);	
	}

	@Test
	public void thirdTest() {

		User user = userMapper.selectById(12);
		System.out.println(user);

	}

}
