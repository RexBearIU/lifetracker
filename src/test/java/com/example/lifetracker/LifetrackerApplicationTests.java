package com.example.lifetracker;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.bean.LifeUser;
import com.example.mapper.DietRecordMapper;
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

	@Resource
	private PasswordEncoder passwordEncoder;
	
	@Resource
	private DietRecordMapper dietRecordMapper;

	@Test
	public void userMapperInsertTest() {
		LifeUser user = new LifeUser(null,"ad","100@1", passwordEncoder.encode("123"));
		userMapper.insert(user);	
	}

	@Test
	public void userMapperSelectByIdTest() {

		LifeUser user = userMapper.selectById(4);
		System.out.println(user);

	}
	@Test
	public void userMapperSelectByNameTest() {

		LifeUser user = userMapper.selectByEmail("s");
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
		LifeUser user = new LifeUser(1,"caca","12635@ss",passwordEncoder.encode("123"));
		boolean createUser = userService.createUser(user);;	
		System.out.println(createUser);
	}
	@Test
	public void userServiceGetTest() {
		
		LifeUser user = userService.getUser("12635@ss");;
		System.out.println(user);
	}

	@Test
	public void userServicePutTest() {
		LifeUser user = new LifeUser(4,"test","test@test",passwordEncoder.encode("test"));
		boolean putUser = userService.putUser(user);
			
		System.out.println(putUser);
	}
	@Test
	public void userServiceDelectTest() {
		
		boolean delectUser = userService.delectUser(14);
		System.out.println(delectUser);
	}

	@Test
	public void name() {
		
	}

}


