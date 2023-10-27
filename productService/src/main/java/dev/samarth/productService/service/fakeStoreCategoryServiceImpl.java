package dev.samarth.productService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.samarth.productService.clients.fakeStoreProductDTO;
import dev.samarth.productService.dto.fakeStoreCategoryDTO;
import dev.samarth.productService.models.Category;
import dev.samarth.productService.models.Product;
@Service
public class fakeStoreCategoryServiceImpl implements CategoryService {
	
	RestTemplateBuilder restTemplateBuilder;

	public fakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplateBuilder = restTemplateBuilder;
	}

	@Override
	public List<Product> getInSingleCategory(String name) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<fakeStoreProductDTO[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products/category/jewelery", 
				fakeStoreProductDTO[].class, name);
		
		List<Product> products = new ArrayList<>();
		
		for(fakeStoreProductDTO Dto : response.getBody()) {
			Product product = new Product();
			product.setId(Dto.getId());
			product.setDescription(Dto.getDescription());
			product.setImageURL(Dto.getImage());
			product.setPrice(Dto.getPrice());
			product.setTitle(Dto.getTitle());
			Category category = new Category();
			category.setName(Dto.getCategory());
			product.setCategory(category);
			products.add(product);
		}
		return products;
	}

	@Override
	public List<Category> getAllCategories() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<fakeStoreCategoryDTO[]> list = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", 
				fakeStoreCategoryDTO[].class);
		List<Category> categories = new ArrayList<>();
		for(fakeStoreCategoryDTO Dto : list.getBody()) {
			Category category = new Category();
			category.setName(Dto.getName());
			categories.add(category);
		}
		return categories;
	}

}
