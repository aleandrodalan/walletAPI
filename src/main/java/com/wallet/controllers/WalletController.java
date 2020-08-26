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

import com.wallet.dto.WalletDTO;
import com.wallet.entities.Wallet;
import com.wallet.response.Response;
import com.wallet.services.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@PostMapping
	public ResponseEntity<Response<WalletDTO>> salvar(@Valid @RequestBody WalletDTO dto, BindingResult result) {
		Response<WalletDTO> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Wallet wallet = walletService.save(convertDtoToEntity(dto));
		
		response.setData(convertEntityToDto(wallet));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private Wallet convertDtoToEntity(WalletDTO dto) {
		return Wallet
					.builder()
					.id(dto.getId())
					.name(dto.getName())
					.value(dto.getValue())
					.build();
	}
	
	private WalletDTO convertEntityToDto(Wallet w) {
		return WalletDTO
					.builder()
					.id(w.getId())
					.name(w.getName())
					.value(w.getValue())
					.build();
	}
}
