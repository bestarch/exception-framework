/*package com.kohls.merch.poedihub.v2.exception;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.kohls.merch.poedihub.ExceptionTest;

//@SpringBootApplication
//@Configuration
//@EnableAspectJAutoProxy
//@ComponentScan("com.kohls.merch.poedihub")
public class ExceptionLibApplication {

	//@Autowired
	//ExceptionTest test;

	public static void main(String[] args) {
		//SpringApplication.run(ExceptionLibApplication.class, args);
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				"com.kohls.merch.poedihub");
		System.out.println(applicationContext.getId());
		ExceptionTest transferService = applicationContext.getBean(ExceptionTest.class);
		transferService.getString("hello");
	}
}
*/