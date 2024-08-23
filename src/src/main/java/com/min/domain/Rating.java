package com.min.domain;

import jakarta.persistence.Entity;

@Entity(name="rate")
public class Rating {
	private int ratingId;
	private int employeeRating;

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}


	public int getEmployeeRating() {
		return employeeRating;
	}

	public void setEmployeeRating(int employeeRating) {
		this.employeeRating = employeeRating;
	}
	@Override
	public String toString() {
		return "Rating{" +
				"ratingId=" + ratingId +
				", employeeRating=" + employeeRating +
				'}';
	}

}
