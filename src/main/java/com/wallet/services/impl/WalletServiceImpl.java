package com.wallet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.entities.Wallet;
import com.wallet.repositories.WalletRepository;
import com.wallet.services.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepository;
	
	@Override
	public Wallet save(Wallet w) {
		return walletRepository.save(w);
	}
}