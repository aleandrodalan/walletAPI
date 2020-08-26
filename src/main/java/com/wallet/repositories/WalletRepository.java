package com.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

}
