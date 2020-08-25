package com.wallet.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.entities.User;
import com.wallet.repositories.UserRepository;
import com.wallet.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User salvar(User u) {
		return repository.save(u);
	}

	@Override
	public Optional<User> buscarPorEmail(String email) {
		return repository.findByEmailEquals(email);
	}
}