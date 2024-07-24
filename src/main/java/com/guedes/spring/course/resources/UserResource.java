package com.guedes.spring.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guedes.spring.course.entities.User;

@RestController
@RequestMapping( value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Leandro Guedes", "leandro.costa30@fatec.sp.gov.br", "13991056490", "audioslave");
		return ResponseEntity.ok().body(u);
	}
	
}
