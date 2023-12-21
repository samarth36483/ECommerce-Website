package dev.samarth.productService.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
@Entity
public class Category extends BaseModel {
	private String name;
	private String description;
	@OneToMany(mappedBy = "category")  // "mapped by" to prevent a relation from being represented twice
	private List<Product> products;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
