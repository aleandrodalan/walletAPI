package com.wallet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	
	Optional<Users> findByEmailEquals(String email);
}