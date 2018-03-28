package com.springboot.thymeleaf.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.springboot.thymeleaf.controller"})
public class SpringBootMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SpringApplication.run(SpringBootMain.class, args);
	}

}
