package com.min.domain;

import java.time.ZonedDateTime;
import java.util.Date;

import jakarta.persistence.*;

@Entity(name = "employee")
public class Employee {
	@Id()
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	private String employeeFirstName;
	
	private String employeeLastName;
	
	private ZonedDateTime dateOfbirth;
	
	private Double netSal;
	
	private Date dateOfJoining;
	
	private String createdBy;
	
	private Date createdAt;
	
	private Long updatedBy;
	
	private ZonedDateTime updatedAt;
	
	private Double grossSalary;
	
	
	//Relations
	
	@OneToMany
	public Address address;
	
	@OneToOne
    public Rating rating;
	
	@OneToMany
	public Banking bank;
	
	private Boolean archive;
	
	
	
	
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public Banking getBank() {
		return bank;
	}
	public void setBank(Banking bank) {
		this.bank = bank;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
 
	public ZonedDateTime getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(ZonedDateTime dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Double getNetSal() {
		return netSal;
	}
	public void setNetSal(Double netSal) {
		this.netSal = netSal;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Double getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", dateOfbirth=" + dateOfbirth + ", netSal=" + netSal + ", dateOfJoining="
				+ dateOfJoining + ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", updatedBy=" + updatedBy
				+ ", updatedAt=" + updatedAt + ", getId()=" + getId() + ", getEmployeeFirstName()="
				+ getEmployeeFirstName() + ", getEmployeeLastName()=" + getEmployeeLastName() + ", getDateOfbirth()="
				+ getDateOfbirth() + ", getUpdatedBy()=" + getUpdatedBy() + ", getUpdatedAt()=" + getUpdatedAt()
				+ ", getNetSal()=" + getNetSal() + ", getDateOfJoining()=" + getDateOfJoining() + ", getCreatedBy()="
				+ getCreatedBy() + ", getCreatedAt()=" + getCreatedAt() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	 
	 	
}
