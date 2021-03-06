package com.wallet.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

	private Long id;
	
	@Email(message = "Email inválido")
	private String email;
	
	@Length(min = 3, max = 30, message = "O nome de conter entre {min} e {max} caracteres")
	private String name;
	
	@NotNull
	@Length(min = 6, message = "A senha deve ter no mínimo {min} caracteres")
	private String password;
}