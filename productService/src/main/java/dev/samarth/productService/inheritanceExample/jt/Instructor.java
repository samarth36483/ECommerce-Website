package dev.samarth.productService.inheritanceExample.jt;

import jakarta.persistence.Entity;

@Entity(name = "jt_instructor")
public class Instructor extends User {
	private boolean isHandsome;

	public boolean isHandsome() {
		return isHandsome;
	}

	public void setHandsome(boolean isHandsome) {
		this.isHandsome = isHandsome;
	}

}
