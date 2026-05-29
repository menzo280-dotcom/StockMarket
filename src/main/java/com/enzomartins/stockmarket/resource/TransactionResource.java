package com.enzomartins.stockmarket.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.enzomartins.stockmarket.service.TransactionService;
import com.enzomartins.stockmarket.dto.PortfolioPositionDTO;
import com.enzomartins.stockmarket.dto.PortfolioSummaryDTO;
import com.enzomartins.stockmarket.dto.TransactionRequestDTO;
import com.enzomartins.stockmarket.entities.Transaction;

import java.net.URI;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionResource {

	@Autowired
	private TransactionService service;
	
	@GetMapping
	public ResponseEntity<List<Transaction>> findAll(){
		List<Transaction> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Transaction> findById(@PathVariable Long id){
		Transaction obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping("/buy")
	public ResponseEntity<Transaction> buy(@RequestBody TransactionRequestDTO dto) {
	    Transaction transaction = service.buyStock(dto.getPortfolioId(),dto.getStockId(), dto.getQuantity());
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transaction.getId()).toUri();
	    return ResponseEntity.created(uri).body(transaction);
	}
	
	
	@PostMapping("/sell")
	public ResponseEntity<Transaction> sell(@RequestBody TransactionRequestDTO dto) {
	    Transaction transaction = service.sellStock(dto.getPortfolioId(),dto.getStockId(), dto.getQuantity());
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transaction.getId()).toUri();
	    return ResponseEntity.created(uri).body(transaction);
	}
	
	@GetMapping("/portfolio/{portfolioId}")
	public ResponseEntity<List<PortfolioPositionDTO>> getPositions(
	        @PathVariable Long portfolioId) {

	    List<PortfolioPositionDTO> positions = service.getPositions(portfolioId);

	    return ResponseEntity.ok().body(positions);
	}
	
	@GetMapping("/portfolio/{portfolioId}/summary")
	public ResponseEntity<PortfolioSummaryDTO>
	getPortfolioSummary(
	        @PathVariable Long portfolioId) {

	    PortfolioSummaryDTO summary =
	            service.getPortfolioSummary(portfolioId);

	    return ResponseEntity.ok().body(summary);
	}
	
	@GetMapping("/portfolio/{portfolioId}/stock/{stockId}")
	public ResponseEntity<List<Transaction>> findHistoryByStock(
	        @PathVariable Long portfolioId,
	        @PathVariable Long stockId) {

	    List<Transaction> list = service.findHistoryByStock(portfolioId, stockId);
	    return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/portfolio/{portfolioId}/history")
	public ResponseEntity<List<Transaction>> findHistoryByPortfolio(
	        @PathVariable Long portfolioId) {

	    List<Transaction> list = service.findHistoryByPortfolio(portfolioId);
	    return ResponseEntity.ok().body(list);
	}
	

}
