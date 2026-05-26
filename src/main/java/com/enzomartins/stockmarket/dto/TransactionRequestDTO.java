package com.enzomartins.stockmarket.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class TransactionRequestDTO {
	
	 @Schema(example = "2")
	 	private Long portfolioId;
	 
	 @Schema(example = "1")
	    private Long stockId;
	 
	 @Schema(example = "10")
	    private Integer quantity;
	 

	    public TransactionRequestDTO() {
	    }

	    public Long getPortfolioId() {
	        return portfolioId;
	    }

	    public void setPortfolioId(Long portfolioId) {
	        this.portfolioId = portfolioId;
	    }

	    public Long getStockId() {
	        return stockId;
	    }

	    public void setStockId(Long stockId) {
	        this.stockId = stockId;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }
	    
	    


}
