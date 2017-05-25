package com.tce.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *项目启动类 
 */
@SpringBootApplication
@EnableSwagger2
public class Application {
	
	public static void main(String[] args) {
		//run
		SpringApplication.run(Application.class, args);
	}
}