package com.recykal.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SignUpDTO {

	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 75)
	private String fullName;

	
	@NotNull(message = "Mobile number is mandatary")
	@NotBlank
	@Pattern(regexp = "(^$|[0-9]{10})")
	@Column( length = 10)
	private String mobileNumber;
	
	@NotNull(message = "email number is mandatary")
	@NotBlank
	@Size(max = 100)
	@Email
	@Column(name = "USER_EMAIL",unique=true)
	private String email;

//
//	@NotNull
//	@Column(name= "USER_STATUS")
//	private Boolean activeInactiveStatus;

//	@NotNull(message = "Password number is mandatary")
//	@NotBlank
	@Column(name = "user_admin_password")
	@Size(min = 8, max = 16)
	private String passward;

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
//
//	public Boolean getActiveInactiveStatus() {
//		return activeInactiveStatus;
//	}
//
//	public void setActiveInactiveStatus(Boolean activeInactiveStatus) {
//		this.activeInactiveStatus = activeInactiveStatus;
//	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SignUpDTO [fullName=" + fullName + ", mobileNumber=" + mobileNumber + ", email=" + email + ", passward="
				+ passward + "]";
	}
	
//	
//	@Override
//	public String toString() {
//		return "SignUpDTO [fullName=" + fullName + ", mobileNumber=" + mobileNumber + ", email=" + email
//				+ ", activeInactiveStatus=" + activeInactiveStatus + ", password=" + passward + "]";
//	}
//  	 
}

 