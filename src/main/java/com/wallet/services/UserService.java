package com.wallet.services;

import java.util.Optional;

import com.wallet.entities.Users;

public interface UserService {

	Users salvar(Users u);
	Optional<Users> buscarPorEmail(String email);
}
