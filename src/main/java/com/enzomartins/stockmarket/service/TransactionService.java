package com.enzomartins.stockmarket.service;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzomartins.stockmarket.dto.PortfolioPositionDTO;
import com.enzomartins.stockmarket.entities.Portfolio;
import com.enzomartins.stockmarket.entities.Stock;
import com.enzomartins.stockmarket.entities.Transaction;
import com.enzomartins.stockmarket.entities.enums.TransactionType;
import com.enzomartins.stockmarket.repository.TransactionRepository;
import com.enzomartins.stockmarket.service.exception.ResourceNotFoundException;
import com.enzomartins.stockmarket.repository.PortifolioRepository;
import com.enzomartins.stockmarket.repository.StockRepository;

@Service
public class TransactionService {	

	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	private PortifolioRepository portfolioRepository;

	@Autowired
	private StockRepository stockRepository;
	
	public Transaction buyStock(Long portfolioId, Long stockId, Integer quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("quantity must be greater than 0");
		}
			Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow((() ->  new ResourceNotFoundException(portfolioId)));
			
			Stock stock = stockRepository.findById(stockId).orElseThrow((() ->  new ResourceNotFoundException(stockId)));
			
			Transaction transaction = new Transaction();
			
			transaction.setPortfolio(portfolio);
			transaction.setStock(stock);
			transaction.setUser(portfolio.getUser());
			transaction.setQuantity(quantity);
			transaction.setMoment(LocalDateTime.now());
			transaction.setPrice(stock.getCurrentPrice());
			transaction.setType(TransactionType.BUY);
			
			return repository.save(transaction);
			
	}
	
	public Transaction sellStock(Long portfolioId, Long stockId, Integer quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("quantity must be greater than 0");
		}
		Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow((() ->  new ResourceNotFoundException(portfolioId)));
		
		Stock stock = stockRepository.findById(stockId).orElseThrow((() ->  new ResourceNotFoundException(stockId)));
		
		Transaction transaction = new Transaction();
		
		List<Transaction> transactions =
			    repository.findByPortfolioAndStock(portfolio, stock);
		
		int balance = 0;
		
		for (Transaction t : transactions) {
			if (t.getType() == TransactionType.BUY) {
			balance += t.getQuantity();
		} else {
			balance -= t.getQuantity();
			}
		}
		
		if (balance < quantity) {
			throw new IllegalArgumentException("insufficient stock balance");
		}		
		transaction.setPortfolio(portfolio);
		transaction.setStock(stock);
		transaction.setUser(portfolio.getUser());
		transaction.setQuantity(quantity);
		transaction.setMoment(LocalDateTime.now());
		transaction.setPrice(stock.getCurrentPrice());
		transaction.setType(TransactionType.SELL);
		
		return repository.save(transaction);
		
		
	}

	public List<Transaction> findAll() {
		return repository.findAll();
	}

	public Transaction findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<PortfolioPositionDTO> getPositions(Long portfolioId) {
		
		Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow((() ->  new ResourceNotFoundException(portfolioId)));
		
		List<Transaction> transactions = repository.findByPortfolio(portfolio);
		
		
		Map<Stock, Integer> position = new HashMap<>();
		
		for (Transaction t : transactions) {
			Stock stock = t.getStock();
			Integer currentQuantity = position.getOrDefault(stock, 0);
			
			if (t.getType() == TransactionType.BUY) {
				position.put(stock, currentQuantity + t.getQuantity());
			} else {
				position.put(stock, currentQuantity - t.getQuantity());
			}
		}
		
		List<PortfolioPositionDTO> result = new ArrayList<>();
		
		for (Map.Entry<Stock, Integer> entry : position.entrySet()) {
		    Stock stock = entry.getKey();
		    Integer quantity = entry.getValue();

		    if (quantity > 0) {
		        PortfolioPositionDTO dto = new PortfolioPositionDTO(stock.getCode(),stock.getCompanyName(),quantity,stock.getCurrentPrice(), quantity * stock.getCurrentPrice());
		        result.add(dto);
		    }
		}

		return result;
	}

		
}




