package dev.samarth.productService.inheritanceExample.msc;

import jakarta.persistence.Entity;

@Entity(name = "msc_ta")
public class TA extends User {
	private double averageRating;

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

}
