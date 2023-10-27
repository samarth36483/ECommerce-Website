package dev.samarth.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.samarth.productService.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Product save(Product product);

}
