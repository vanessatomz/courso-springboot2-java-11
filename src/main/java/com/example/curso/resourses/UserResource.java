package com.example.curso.resourses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entities.User;

@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L,"Maria","maria@gmaiçom","9294859203","1234");
		return ResponseEntity.ok().body(u);
	}
}

