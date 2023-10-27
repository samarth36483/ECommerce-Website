package dev.samarth.productService.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.samarth.productService.dto.ErrorResponseDTO;
import dev.samarth.productService.dto.ProductDTO;
import dev.samarth.productService.exceptions.ProductNotFoundException;
import dev.samarth.productService.models.Category;
import dev.samarth.productService.models.Product;
import dev.samarth.productService.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}


	@GetMapping("/{product_id}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable("product_id") Long product_id) throws ProductNotFoundException {
		
		Optional<Product> OptProduct = productService.getSingleProduct(product_id);
		
		if(OptProduct.isEmpty()) {
			throw new ProductNotFoundException("No product with product id : " + product_id);
		}
		
		ResponseEntity<Product> response = new ResponseEntity(productService.getSingleProduct(product_id), HttpStatus.OK);
		
		return response;
	}
	
	@GetMapping("")
	public List<Product> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return products;
	}
	
	@PostMapping("")
	public Product addNewProduct(@RequestBody ProductDTO productDto) {
		Product product = productService.addNewProduct(productDto);
		//ResponseEntity<Product> response = new ResponseEntity<Product>(product, HttpStatus.OK);
		return product;
	}
	
	@PatchMapping("/{product_id}")
	public Product updateProduct(@PathVariable("product_id") long product_id, @RequestBody ProductDTO productDto) {
		Product product = new Product();
		product.setTitle(productDto.getTitle());
		product.setPrice(productDto.getPrice());
		product.setImageURL(productDto.getImage());
		product.setDescription(productDto.getDescription());
		Category category = new Category();
		category.setName(productDto.getCategory());
		product.setCategory(category);
		
		return productService.updateProduct(product_id, product);
	}
	
	@DeleteMapping("{product_id}")
	public String deleteProduct(@PathVariable("product_id") long product_id) {
		boolean is_deleted = productService.deleteProduct(product_id);
		if(is_deleted == true)
		return "The product has been deleted successfully";
		
		return "Something went wrong, please try again.";
	}
	
//	@ExceptionHandler(ProductNotFoundException.class)
//	public ResponseEntity<ErrorResponseDTO> handleException(ProductNotFoundException exception) {
//		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
//		errorResponseDTO.setErrorMessage(exception.getMessage());
//		
//		return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
//	}

}
