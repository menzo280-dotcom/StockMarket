package com.enzomartins.stockmarket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enzomartins.stockmarket.entities.Stock;

public interface StockRepository  extends JpaRepository<Stock, Long> {
    Optional<Stock> findByCode(String code);
}
