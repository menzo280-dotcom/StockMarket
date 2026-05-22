package com.enzomartins.stockmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzomartins.stockmarket.service.exception.ResourceNotFoundException;
import com.enzomartins.stockmarket.entities.Stock;
import com.enzomartins.stockmarket.repository.StockRepository;
import java.util.List;


@Service
public class StockService {
	@Autowired
	private StockRepository repository;
	
	public List<Stock> findAll(){
		return repository.findAll();
	}
	public Stock findById(Long id) {
	    return repository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	 public Stock findByCode(String code) {
	        if (code == null || code.isBlank()) {
	            throw new IllegalArgumentException("Code cannot be null or empty");
	        }
	        
	    return repository.findByCode(code)
	            .orElseThrow(() -> new ResourceNotFoundException(code));
	}
	
	 public Stock insert(Stock obj) {
	        if (obj.getCode() == null || obj.getCode().isBlank()) {
	            throw new IllegalArgumentException("Code cannot be null or empty");
	        }
	        if (obj.getCurrentPrice() == null || obj.getCurrentPrice() <= 0) {
	            throw new IllegalArgumentException("Price must be greater than 0");
	        }
	        if (repository.findByCode(obj.getCode()).isPresent()) {
	            throw new IllegalArgumentException("Code already exists");
	        }
	        
	        return repository.save(obj);
	 }

}
