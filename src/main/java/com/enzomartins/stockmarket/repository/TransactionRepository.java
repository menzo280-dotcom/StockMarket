package com.enzomartins.stockmarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.enzomartins.stockmarket.entities.Transaction;
import com.enzomartins.stockmarket.entities.Portfolio;
import com.enzomartins.stockmarket.entities.Stock;

public interface TransactionRepository  extends JpaRepository<Transaction, Long> {
	List<Transaction> findByPortfolio(Portfolio portfolio);
	
	List<Transaction> findByPortfolioAndStock(
		    Portfolio portfolio,
		    Stock stock
		);
}
