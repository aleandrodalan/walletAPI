package com.wallet.services;

import java.util.Optional;

import com.wallet.entities.User;

public interface UserService {

	User salvar(User u);
	Optional<User> buscarPorEmail(String email);
}
