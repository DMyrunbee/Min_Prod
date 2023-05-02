package com.recykal.entity;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.Fetch;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Orderstable")
public class OrdersList {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private Long orderId;
	
 
	@NotNull
	@NotBlank
	@Size(min = 2, max = 200)
	@Column(nullable = false)
	private String materialName;
	
 
	@Column
	private Double price;


	 
	@Column(nullable = false)
	private Float quantity;
	
	@Column(nullable = false)
	private String orderStatus;
	
	 

	@Column(name="OpenDateTime")
	private ZonedDateTime openDate;
	

	@Column(name="InprogressDateTime")
	private ZonedDateTime inProgressDate;
	
	

	@Column(name="CompletedDateTime")
	private ZonedDateTime CompletedDate;
	
	


	
	@ManyToOne
	@JoinColumn(name = "user_admin_id")
	@JsonIgnore
 	private User user;
	
	
	public OrdersList() {
	 
     }
 
	public Long getOrderId() {
		return orderId;
	}



	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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




	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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


	public String getOrderStatus() {
		return orderStatus;
	}

 
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrdersList [orderId=" + orderId + ", materialName=" + materialName + ", price=" + price + ", quantity="
				+ quantity + ", orderStatus=" + orderStatus + ", openDate=" + openDate + ", inProgressDate="
				+ inProgressDate + ", CompletedDate=" + CompletedDate + ", user=" + user + "]";
	}
 
 

}