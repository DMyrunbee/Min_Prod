package com.recykal.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderUpdateDTO {
	@NotNull
	@NotBlank
 	private Double price;
	
	
	@NotNull
	@NotBlank
 	private Float quantity;
	
	private String orderStatus;

	
	public OrderUpdateDTO() {
		// TODO Auto-generated constructor stub
	}
 
 

	public OrderUpdateDTO(@NotNull @NotBlank Double price, @NotNull @NotBlank Float quantity, String orderStatus) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
	}



	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public String getOrderStatus() {
		return orderStatus;
	}



	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}



	@Override
	public String toString() {
		return "OrderUpdateDTO [price=" + price + ", quantity=" + quantity + ", orderStatus=" + orderStatus + "]";
	}
	
	
	
}
