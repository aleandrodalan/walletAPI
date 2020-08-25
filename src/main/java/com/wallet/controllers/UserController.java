package com.wallet.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.UserDTO;
import com.wallet.entities.User;
import com.wallet.response.Response;
import com.wallet.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult result) {
		Response<UserDTO> response = new Response<>();
		
		User user = userService.salvar(convertDTOToEntity(dto));
		
		response.setData(convertEntityToDTO(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private User convertDTOToEntity(UserDTO dto) {
		return User
				.builder()
				.email(dto.getEmail())
				.name(dto.getName())
				.password(dto.getPassword())
				.build();
	}
	
	private UserDTO convertEntityToDTO(User user) {
		return UserDTO
				.builder()
				.email(user.getEmail())
				.name(user.getName())
				.password(user.getPassword())
				.build();				
	}
	
}