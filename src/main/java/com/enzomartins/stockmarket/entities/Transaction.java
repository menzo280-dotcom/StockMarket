package com.enzomartins.stockmarket.entities;

import java.io.Serializable;

import java.time.LocalDateTime;

import com.enzomartins.stockmarket.entities.enums.TransactionType;

import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "tb_transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime moment;
	
	@ManyToOne
	@JoinColumn(name = "stock_id")
	private Stock stock;
	
	@ManyToOne
	@JoinColumn(name = "portfolio_id")
	private Portfolio portfolio;
	
	
	private Integer quantity;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
		private User user;
	
	@Enumerated(EnumType.STRING)
	private TransactionType type;

	
	public Transaction() {
		
	}
	public Transaction(Long id, LocalDateTime moment, Stock stock, Integer quantity, Double price,
			TransactionType type, User user) {
		super();
		this.id = id;
		this.moment = moment;
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
		this.type = type;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getMoment() {
		return moment;
	}
	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	
	public Double getTotal() {
	    return quantity * price;
	}
	
	public Portfolio getPortfolio() {
	    return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
	    this.portfolio = portfolio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
