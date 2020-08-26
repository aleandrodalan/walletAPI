package com.wallet.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalletDTO {

	private Long id;

	@Length(min = 3, message = "Nome deve ter no mínimo {min} caracteres")
	@NotNull(message = "Nome não deve ser nulo")
	private String name;
	
	@NotNull(message = "Valor não deve ser nulo")
	private BigDecimal value;
}
