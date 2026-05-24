package com.enzomartins.stockmarket.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.enzomartins.stockmarket.entities.Portfolio;
import com.enzomartins.stockmarket.entities.User;

public interface TransactionRepository  extends JpaRepository<Portfolio, Long> {
	Optional<Portfolio> findByUser(User user);
}
