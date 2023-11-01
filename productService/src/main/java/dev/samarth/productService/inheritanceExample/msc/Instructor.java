package dev.samarth.productService.inheritanceExample.msc;

import jakarta.persistence.Entity;

@Entity(name = "msc_instructor")
public class Instructor extends User {
	private boolean isHandsome;

	public boolean isHandsome() {
		return isHandsome;
	}

	public void setHandsome(boolean isHandsome) {
		this.isHandsome = isHandsome;
	}

}
