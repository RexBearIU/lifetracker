package com.example.lifetracker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class LifetrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifetrackerApplication.class, args);
	}

}
