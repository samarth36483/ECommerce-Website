package dev.samarth.productService;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import dev.samarth.productService.models.Category;
import dev.samarth.productService.models.Product;
import dev.samarth.productService.repository.CategoryRepository;
import dev.samarth.productService.repository.ProductRepository;

@SpringBootTest
public class ProductTest {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	// below is the method to test cascade types
	@Test
	void saveProduct() {
		//Category category = new Category();
//		category.setName("electronics");
//		//Category savedCategory = categoryRepository.save(category);   // either uncomment this save 
//																		//or change the cascading to persist in Product class
		//Product product = new Product();
//		product.setCategory(category);
//		product.setDescription("hello");
//		product.setPrice(100);
//		
//		Product prod = productRepository.save(product);
		productRepository.deleteById(52L);
	}
	
	// below is the test case for eager and lazy loading
//	@Test
//	@Transactional  // added transactional because without it the application will throw error while fetching name
//	void fetchType() {
//		Optional<Product> product = productRepository.findById(1L);
//		
//		System.out.println("fetched product");
//		
//		Product prod = product.get();
//		Category category = prod.getCategory();
//		String name = category.getName();   // here
//	}

}
