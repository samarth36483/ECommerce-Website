package dev.samarth.productService.inheritanceExample.st;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class Instructor extends User {
	private boolean isHandsome;

	public boolean isHandsome() {
		return isHandsome;
	}

	public void setHandsome(boolean isHandsome) {
		this.isHandsome = isHandsome;
	}

}
