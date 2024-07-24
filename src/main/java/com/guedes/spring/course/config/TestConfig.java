package com.guedes.spring.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.guedes.spring.course.entities.Order;
import com.guedes.spring.course.entities.User;
import com.guedes.spring.course.repositories.OrderRepository;
import com.guedes.spring.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Leandro Guedes Costa", "leandro.costa30@fatec.sp.gov.br", "991033011", "StarLord");
		User u2 = new User(null, "Debora Ribeiro Santana", "dede_2santana@hotmail.com", "988464445", "DixieKong");
		User u3 = new User(null, "Juliana Cristina Vieira", "itsjuliana@hotmail.com", "997532551", "LolaBunny");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
