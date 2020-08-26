package com.wallet.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.entities.Users;
import com.wallet.repositories.UserRepository;
import com.wallet.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public Users salvar(Users u) {
		return repository.save(u);
	}

	@Override
	public Optional<Users> buscarPorEmail(String email) {
		return repository.findByEmailEquals(email);
	}
}