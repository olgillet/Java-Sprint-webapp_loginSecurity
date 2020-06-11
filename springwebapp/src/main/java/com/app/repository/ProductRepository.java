package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByDescription(String description);
	
	// Find Product by Word contained in Description
	@Query("select p from Product p where p.description like %:description%")
    public List<Product> findByDescriptionLike(@Param("description") String description);
	
	public List<Product> findProductByUnitPriceBetween(Double price1, Double price2);
}
