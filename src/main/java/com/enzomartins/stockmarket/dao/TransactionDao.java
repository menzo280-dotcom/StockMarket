package com.enzomartins.stockmarket.dao;

import java.util.List;

import com.enzomartins.stockmarket.entities.Transaction;
import com.enzomartins.stockmarket.entities.User;

public interface TransactionDao {
	
	Transaction findById(Long id) ;
	
	List<Transaction> findByUser(User user);
	
	void insert(Transaction transaction) ;
	

}
