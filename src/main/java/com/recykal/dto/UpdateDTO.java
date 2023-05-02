package com.recykal.dto;

public class UpdateDTO {
	private Double price;
	
	private Float quantity;
	
	public UpdateDTO() {
		// TODO Auto-generated constructor stub
	}

	public UpdateDTO(Double price, Float quantity) {
		super();
		this.price = price;
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "UpdateDTO [price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	
}
