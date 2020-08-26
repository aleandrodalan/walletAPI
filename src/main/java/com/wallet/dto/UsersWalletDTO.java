package com.wallet.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersWalletDTO {

	private Long id;
	
	@NotNull(message = "Informe o id do usuário")
	private Long users;
	
	@NotNull(message = "Informe o id da carteira")	
	private Long wallet;
}
