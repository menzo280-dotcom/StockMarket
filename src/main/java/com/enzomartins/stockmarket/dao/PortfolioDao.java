package com.enzomartins.stockmarket.dao;

import com.enzomartins.stockmarket.entities.Portfolio;
import com.enzomartins.stockmarket.entities.User;
import java.util.List;

public interface PortfolioDao {
	
	
	
	Portfolio findById(Long id) ;
	
	List<Portfolio> findByUser(User user);

	void insert(Portfolio port);

	void update(Portfolio port);
	

}
