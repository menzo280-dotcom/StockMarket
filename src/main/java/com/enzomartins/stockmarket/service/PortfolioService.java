package com.enzomartins.stockmarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzomartins.stockmarket.repository.PortifolioRepository;
import com.enzomartins.stockmarket.service.exception.ResourceNotFoundException;
import com.enzomartins.stockmarket.entities.Portfolio;

@Service
public class PortfolioService {
	@Autowired
	private PortifolioRepository repository;
	
	public List<Portfolio> findAll(){
		return repository.findAll();
	}
	
	public Portfolio findById(Long Id) {
		Optional <Portfolio> obj = repository.findById(Id);
		return obj.orElseThrow(() ->  new ResourceNotFoundException(Id));
	}

	public Portfolio insert(Portfolio obj) {
		return repository.save(obj);
	}

}
