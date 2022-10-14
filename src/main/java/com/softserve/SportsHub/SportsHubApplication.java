package com.softserve.SportsHub;


import com.softserve.SportsHub.config.AppInitializer;
import com.softserve.SportsHub.config.HibernateConfig;
import com.softserve.SportsHub.config.WebConfig;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@Configuration
@ComponentScan
@EnableJpaRepositories(basePackages = "com.softserve.SportsHub.user")
//@Import({AppInitializer.class, HibernateConfig.class, WebConfig.class})
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
