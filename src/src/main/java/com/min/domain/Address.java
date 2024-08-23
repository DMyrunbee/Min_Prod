package com.min.domain;

import java.util.Objects;
import jakarta.persistence.Entity;

@Entity(name ="address")
public class Address {

	private Integer addressId;
	private String name;
	private String state;
	private String district;
	private String cityortown;



	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCityortown() {
		return cityortown;
	}
	public void setCityortown(String cityortown) {
		this.cityortown = cityortown;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", name=" + name + ", state=" + state + ", district=" + district
				+ ", cityortown=" + cityortown + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(addressId, cityortown, district, name, state);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return addressId == other.addressId && Objects.equals(cityortown, other.cityortown)
				&& Objects.equals(district, other.district) && Objects.equals(name, other.name)
				&& Objects.equals(state, other.state);
	}
	
}
