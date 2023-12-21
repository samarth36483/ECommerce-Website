package dev.samarth.productService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.samarth.productService.models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product save(Product product);
	
	Optional<Product> findById(Long productId);
	
	void deleteById(Long productId);
}
