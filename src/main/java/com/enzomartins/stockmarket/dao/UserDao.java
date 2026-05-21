package com.enzomartins.stockmarket.dao;

import com.enzomartins.stockmarket.entities.User;

public interface UserDao {

	User findById(Long id);

	User findByEmail(String email);

	void insert(User user);

	void update(User user);

}