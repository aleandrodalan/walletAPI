package com.wallet.repository;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.wallet.entities.User;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	private UserRepository repository;
	
	@BeforeEach
	public void setUp() {
		User user = new User();
		user.setName("Set up User");
		user.setEmail(EMAIL);
		user.setPassword("teste123");
		
		
		repository.save(user);		
	}
	
	@AfterEach
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void testSalvar() {
		User user = new User();
		user.setName("Teste");
		user.setEmail("teste@teste.com");
		user.setPassword("123456");
		
		User response = repository.save(user);
		
		Assertions.assertNotNull(response);
	}
	
	@Test
	public void testBuscaPorEmail() {
		Optional<User> user = repository.findByEmailEquals(EMAIL);
		
		Assertions.assertTrue(user.isPresent());
		Assertions.assertEquals(user.get().getEmail(), EMAIL);
	}
}
