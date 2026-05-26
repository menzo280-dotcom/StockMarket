package com.enzomartins.stockmarket.dto;

public class PortfolioPositionDTO {
	
	private String stockCode;
	private String companyName;
	private Integer quantity;
	private Double currentPrice;
	private Double marketValue;
	
	public PortfolioPositionDTO() {
		
	}
	
	

	public PortfolioPositionDTO(String stockCode, String companyName, Integer quantity, Double currentPrice,
			Double marketValue) {	
		this.stockCode = stockCode;
		this.companyName = companyName;
		this.quantity = quantity;
		this.currentPrice = currentPrice;
		this.marketValue = marketValue;
	}



	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}

	
}
