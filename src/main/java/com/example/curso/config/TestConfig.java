package com.example.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.curso.entities.Category;
import com.example.curso.entities.Order;
import com.example.curso.entities.User;
import com.example.curso.entities.enums.OrderStatus;
import com.example.curso.repositories.CategoryRepository;
import com.example.curso.repositories.OrderRepository;
import com.example.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepoistory;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com","9824859384","123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com","9384953845","123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID ,u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT ,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.SHIPPED ,u1); 
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		orderRepoistory.saveAll(Arrays.asList(o1,o2,o3));

	}
}

