package com.recykal.dto;

import java.time.ZonedDateTime;

import com.recykal.entity.User;

public class OrderUserDTO {
		private String customerName;
		
		private Long orderId;
		 
		private Double price;
		
		private String Material;
		
		private  Float Quantity;
		
		private String status;
	
		private ZonedDateTime orderedTime;
		
		private User user;
		 
 
 
		public OrderUserDTO(String customerName, Long orderId, Double price, String material, Float quantity,
				String status, ZonedDateTime orderedTime, User user) {
			super();
			this.customerName = customerName;
			this.orderId = orderId;
			this.price = price;
			this.Material = material;
			this.Quantity = quantity;
			this.status = status;
			this.orderedTime = orderedTime;
			this.user = user;
		}



		public OrderUserDTO(String fullName, Long orderId2, ZonedDateTime date, Double price2, String materialName,
				String orderStatus) {
			
			super();
			this.customerName=fullName;
			this.orderId=orderId2;
			this.orderedTime=date;
			this.price=price2;
			this.Material=materialName;
			this.status=orderStatus;
 		}



		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
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

		public String getMaterial() {
			return Material;
		}

		public void setMaterial(String material) {
			Material = material;
		}

		public Float getQuantity() {
			return Quantity;
		}

		public void setQuantity(Float quantity) {
			Quantity = quantity;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public ZonedDateTime getOrderedTime() {
			return orderedTime;
		}

		public void setOrderedTime(ZonedDateTime orderedTime) {
			this.orderedTime = orderedTime;
		}
		

		public User getUser() {
			return user;
		}



		public void setUser(User user) {
			this.user = user;
		}



		@Override
		public String toString() {
			return "ViewDTO [customerName=" + customerName + ", orderId=" + orderId + ", price=" + price + ", Material="
					+ Material + ", Quantity=" + Quantity + ", status=" + status + ", orderedTime=" + orderedTime
					+ ", user=" + user + "]";
		}


 

		 
		
}
