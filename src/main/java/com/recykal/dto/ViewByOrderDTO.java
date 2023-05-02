package com.recykal.dto;

import java.time.ZonedDateTime;
import java.util.List;

import com.recykal.entity.OrdersList;

import jakarta.persistence.Column;

public class ViewByOrderDTO {
	
	private String user_name;
	
	private Long orderId;

	private Double price;	
	
	private Float quantity;

	private String orderStatus;	

 	private ZonedDateTime openDate;
	
 	private ZonedDateTime inProgressDate;
	
 	private ZonedDateTime CompletedDate;

 	public ViewByOrderDTO() {
 
 	}
 		
	public ViewByOrderDTO(String user_name, Long orderId, Double price, Float quantity, String orderStatus,
			ZonedDateTime openDate, ZonedDateTime inProgressDate, ZonedDateTime completedDate) {
		super();
		this.user_name = user_name;
		this.orderId = orderId;
		this.price = price;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
		this.openDate = openDate;
		this.inProgressDate = inProgressDate;
		CompletedDate = completedDate;
	}

	 

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	@Override
	public String toString() {
		return "ViewByOrderDTO [user_name=" + user_name + ", orderId=" + orderId + ", price=" + price + ", quantity="
				+ quantity + ", orderStatus=" + orderStatus + ", openDate=" + openDate + ", inProgressDate="
				+ inProgressDate + ", CompletedDate=" + CompletedDate + "]";
	}
 	
 	
 	
	
	
}
