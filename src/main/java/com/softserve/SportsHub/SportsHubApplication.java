package com.softserve.SportsHub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SportsHubApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SportsHubApplication.class, args);
	}

	public void run(String... args) {
		User user = new User("john", false, false);
		userRepository.save(user);
		List<User> users = userRepository.findAll();
		users.forEach(System.out::println);
	}

}
