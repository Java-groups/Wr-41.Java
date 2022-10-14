package com.softserve.sportshub;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SportsHubApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SportsHubApplication.class);

		Test testBean = ctx.getBean(Test.class);
		System.out.println(testBean.getMessage());

	}

	@Bean
	public String giveMeString(){
		return "Hello";
	}
}
