package com.recykal.dto;

import java.time.ZonedDateTime;

public class AddUserDTO {
		private  String  fullName;
		
		
		private String mobileNumber;
		
		private String email;
		
		private String deportment;
		
		private String passward;
		
		
		private String activeInactiveStatus;
		
		private ZonedDateTime time;
		
		
		public AddUserDTO() {
			// TODO Auto-generated constructor stub
		}

		public AddUserDTO(String fullName, String mobileNumber, String email, String deportment, String passward,
				String activeInactiveStatus, ZonedDateTime time) {
			super();
			this.fullName = fullName;
			this.mobileNumber = mobileNumber;
			this.email = email;
			this.deportment = deportment;
			this.passward = passward;
			this.activeInactiveStatus = activeInactiveStatus;
			this.time = time;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getDeportment() {
			return deportment;
		}

		public void setDeportment(String deportment) {
			this.deportment = deportment;
		}

		public String getPassward() {
			return passward;
		}

		public void setPassward(String passward) {
			this.passward = passward;
		}

		public String getActiveInactiveStatus() {
			return activeInactiveStatus;
		}

		public void setActiveInactiveStatus(String activeInactiveStatus) {
			this.activeInactiveStatus = activeInactiveStatus;
		}

		public ZonedDateTime getTime() {
			return time;
		}

		public void setTime(ZonedDateTime time) {
			this.time = time;
		}

		@Override
		public String toString() {
			return "AddUserDTO [fullName=" + fullName + ", mobileNumber=" + mobileNumber + ", email=" + email
					+ ", deportment=" + deportment + ", passward=" + passward + ", activeInactiveStatus="
					+ activeInactiveStatus + ", time=" + time + "]";
		}
		
		
		
		
		
}
