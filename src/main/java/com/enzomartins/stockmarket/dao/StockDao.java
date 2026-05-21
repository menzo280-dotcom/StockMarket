package com.enzomartins.stockmarket.dao;

import com.enzomartins.stockmarket.entities.Stock;

public interface StockDao {

	Stock findById(Long id);

	Stock findByCode(String code);

	void insert(Stock stock);

	void update(Stock stock);

}
