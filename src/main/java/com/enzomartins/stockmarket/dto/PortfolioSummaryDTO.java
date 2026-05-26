package com.enzomartins.stockmarket.dto;

public class PortfolioSummaryDTO {
	
	 private Long portfolioId;
	    private Double totalMarketValue;

	    public PortfolioSummaryDTO() {
	    }

	    public PortfolioSummaryDTO(Long portfolioId, Double totalMarketValue) {
	        this.portfolioId = portfolioId;
	        this.totalMarketValue = totalMarketValue;
	    }

	    public Long getPortfolioId() {
	        return portfolioId;
	    }

	    public void setPortfolioId(Long portfolioId) {
	        this.portfolioId = portfolioId;
	    }

	    public Double getTotalMarketValue() {
	        return totalMarketValue;
	    }

	    public void setTotalMarketValue(Double totalMarketValue) {
	        this.totalMarketValue = totalMarketValue;
	    }

}
