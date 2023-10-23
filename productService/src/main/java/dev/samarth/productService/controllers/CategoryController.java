package dev.samarth.productService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.samarth.productService.models.Category;
import dev.samarth.productService.models.Product;
import dev.samarth.productService.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@GetMapping("/{category_name}")
	public List<Product> getSingleCategory(@PathVariable("category_name") String category_name) {
		List<Product> products = categoryService.getInSingleCategory(category_name);
		return products;
	}
	
	@GetMapping("")
	public List<Category> getAllCategories(){
		List<Category> categories = categoryService.getAllCategories();
		return categories;
	}

}
