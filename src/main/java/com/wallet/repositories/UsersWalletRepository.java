package com.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.entities.UsersWallet;

public interface UsersWalletRepository extends JpaRepository<UsersWallet, Long> {

}
