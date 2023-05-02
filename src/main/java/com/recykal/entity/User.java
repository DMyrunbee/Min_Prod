package com.recykal.entity;

import java.time.ZonedDateTime;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "UserDetails")
 public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "User_admin_id")
	private Long id;
	
	
	 
	@NotNull
	@NotBlank
	@Column(name = "USER_NAME")
	@Size(min = 2, max = 75)
	private String fullName;

	@NotNull(message = "Mobile number is mandatary")
	@NotBlank
	@Pattern(regexp = "(^$|[0-9]{10})")
	@Column(name = "user_mobileNumber", length = 10,unique=true)
	private String mobileNumber;

	@NotNull(message = "email number is mandatary")
	@NotBlank
	@Size(max = 100)
	@Email
	@Column(name = "USER_EMAIL",unique=true)
	private String email;

	@Column(name = "USER_DEPORTMENT")
	@Size(min = 4, max = 5)
	private String deportment;

	@NotNull
	@Column(name = "USER_STATUS")
	private Boolean activeInactiveStatus;

	@NotNull(message = "Password number is mandatary")
	@NotBlank
	@Column(name = "USER_PASSWORD")
	@Size(min = 8, max = 10000)
	private String passward;
	 
	
	@OneToMany(mappedBy = "user")
	private List<OrdersList> ordersLists;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(Long id, @NotNull @NotBlank @Size(min = 2, max = 75) String fullName,
			@NotNull(message = "Mobile number is mandatary") @NotBlank @Pattern(regexp = "(^$|[0-9]{10})") String mobileNumber,
			@NotNull(message = "email number is mandatary") @NotBlank @Size(max = 100) @Email String email,
			@Size(min = 4, max = 5) String deportment, @NotNull Boolean activeInactiveStatus,
			@NotNull(message = "Password number is mandatary") @NotBlank @Size(min = 8, max = 10000) String passward,
			@NotNull Boolean action, ZonedDateTime date) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.deportment = deportment;
		this.activeInactiveStatus = activeInactiveStatus;
		this.passward = passward;
		this.date = date;
	}
 
	
	private ZonedDateTime date;

 

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getActiveInactiveStatus() {
		return activeInactiveStatus;
	}

	public void setActiveInactiveStatus(Boolean activeInactiveStatus) {
		this.activeInactiveStatus = activeInactiveStatus;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}
	
  
	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", deportment=" + deportment + ", activeInactiveStatus=" + activeInactiveStatus + ", passward="
				+ passward + ",   date=" + date + "]";
	}
 
}
