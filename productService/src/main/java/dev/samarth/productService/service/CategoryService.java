 package dev.samarth.productService.service;

import java.util.List;

import dev.samarth.productService.models.Category;
import dev.samarth.productService.models.Product;

public interface CategoryService {
	
	List<Product> getInSingleCategory(String name);
	
	List<Category> getAllCategories();

}
