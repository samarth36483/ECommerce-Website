package dev.samarth.productService.inheritanceExample.tpc;

import jakarta.persistence.Entity;

@Entity(name = "tpc_ta")
public class TA extends User {
	private double averageRating;

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

}
