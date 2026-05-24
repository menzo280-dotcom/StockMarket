package com.enzomartins.stockmarket.dto;

public class TransactionRequestDTO {
	
	 private Long portfolioId;
	    private Long stockId;
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
