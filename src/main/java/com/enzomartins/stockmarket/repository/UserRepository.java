package com.enzomartins.stockmarket.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.enzomartins.stockmarket.entities.User;

public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
