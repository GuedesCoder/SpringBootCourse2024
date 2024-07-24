package com.guedes.spring.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.guedes.spring.course.entities.User;
import com.guedes.spring.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Leandro Guedes Costa", "leandro.costa30@fatec.sp.gov.br", "991033011", "StarLord");
		User u2 = new User(null, "Debora Ribeiro Santana", "dede_2santana@hotmail.com", "988464445", "DixieKong");
		User u3 = new User(null, "Juliana Cristina Vieira", "itsjuliana@hotmail.com", "997532551", "LolaBunny");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}
	
}
