package com.recykal.dto;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class OrderDTO {
	
	
	 
	private String fullName;
  
	 
	private Long userId;
	 
	 
	private ZonedDateTime openDate;
	

 	private ZonedDateTime inProgressDate;
	
	

 	private ZonedDateTime CompletedDate;
	
	  
	private String materialName;

	private Double price;
	
	 
	private Float quantity;
	 
 	private String orderStatus;
	
	public OrderDTO() {
 
	
	}

	public OrderDTO(String fullName, Long userId, ZonedDateTime openDate, ZonedDateTime inProgressDate,
			ZonedDateTime completedDate, String materialName, Double price, Float quantity, String orderStatus) {
		super();
		this.fullName = fullName;
		this.userId = userId;
		this.openDate = openDate;
		this.inProgressDate = inProgressDate;
		this.CompletedDate = completedDate;
		this.materialName = materialName;
		this.price = price;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public ZonedDateTime getOpenDate() {
		return openDate;
	}

	public void setOpenDate(ZonedDateTime openDate) {
		this.openDate = openDate;
	}

	public ZonedDateTime getInProgressDate() {
		return inProgressDate;
	}

	public void setInProgressDate(ZonedDateTime inProgressDate) {
		this.inProgressDate = inProgressDate;
	}

	public ZonedDateTime getCompletedDate() {
		return CompletedDate;
	}

	public void setCompletedDate(ZonedDateTime completedDate) {
		CompletedDate = completedDate;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
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
		return "OrderDTO [fullName=" + fullName + ", userId=" + userId + ", openDate=" + openDate + ", inProgressDate="
				+ inProgressDate + ", CompletedDate=" + CompletedDate + ", materialName=" + materialName + ", price="
				+ price + ", quantity=" + quantity + ", orderStatus=" + orderStatus + "]";
	}
	
 
 
}