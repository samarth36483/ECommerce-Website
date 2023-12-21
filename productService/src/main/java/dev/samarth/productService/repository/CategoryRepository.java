package dev.samarth.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.samarth.productService.models.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category save(Category category);

}
