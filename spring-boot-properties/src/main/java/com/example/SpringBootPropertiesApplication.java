package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootPropertiesApplication.class, args);
		HelloService helloService = applicationContext.getBean(HelloService.class);
		helloService.sayHello("Test");
	}

}
