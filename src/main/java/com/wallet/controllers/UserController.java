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
import com.wallet.entities.Users;
import com.wallet.response.Response;
import com.wallet.services.UserService;
import com.wallet.util.Bcrypt;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult result) {
		Response<UserDTO> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Users user = userService.salvar(convertDTOToEntity(dto));
		
		response.setData(convertEntityToDTO(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private Users convertDTOToEntity(UserDTO dto) {
		return Users
				.builder()
				.id(dto.getId())
				.email(dto.getEmail())
				.name(dto.getName())
				.password(Bcrypt.getHash(dto.getPassword()))
				.build();
	}
	
	private UserDTO convertEntityToDTO(Users user) {
		return UserDTO
				.builder()
				.id(user.getId())
				.email(user.getEmail())
				.name(user.getName())
				.build();				
	}
	
}