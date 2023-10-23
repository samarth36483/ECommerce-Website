package dev.samarth.productService.dto;

import lombok.ToString;

@ToString
public class fakeStoreCategoryDTO {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
