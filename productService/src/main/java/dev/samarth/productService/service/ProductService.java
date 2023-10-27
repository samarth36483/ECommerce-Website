package dev.samarth.productService.service;

import java.util.List;
import java.util.Optional;

import dev.samarth.productService.dto.ProductDTO;
import dev.samarth.productService.models.Product;

public interface ProductService {
	
	Optional<Product> getSingleProduct(Long product_id);
	
	List<Product> getAllProducts();
	
	Product addNewProduct(ProductDTO  product);
	
	Product updateProduct(long product_id, Product product);
	
	boolean deleteProduct(long product_id);

}
