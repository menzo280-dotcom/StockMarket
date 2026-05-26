package com.enzomartins.stockmarket.dto;

public class PortfolioPositionDTO {
	
	private String stockCode;
	private String companyName;
	private Integer quantity;
	private Double currentPrice;
	private Double marketValue;
	private Double averagePrice;
    private Double profitLoss;
	
	
	public PortfolioPositionDTO() {
		
	}
	
	 public PortfolioPositionDTO(String stockCode, String companyName, Integer quantity,
	            Double currentPrice, Double marketValue, Double averagePrice, Double profitLoss) {
	        this.stockCode = stockCode;
	        this.companyName = companyName;
	        this.quantity = quantity;
	        this.currentPrice = currentPrice;
	        this.marketValue = marketValue;
	        this.averagePrice = averagePrice;
	        this.profitLoss = profitLoss;
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

	 public Double getAveragePrice() {
		 return averagePrice;
	 }

	 public void setAveragePrice(Double averagePrice) {
		 this.averagePrice = averagePrice;
	 }

	 public Double getProfitLoss() {
		 return profitLoss;
	 }

	 public void setProfitLoss(Double profitLoss) {
		 this.profitLoss = profitLoss;
	 }

}
