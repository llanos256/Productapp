package com.productdb.productapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productdb.productapp.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@EntityGraph("branch") 
	@Query("""
		    SELECT p
		    FROM Product p
		    WHERE p.stock = (
		        SELECT MAX(p2.stock)
		        FROM Product p2
		        WHERE p2.branch.id = p.branch.id
		    )
		""")
		List<Product> findProductsWithMaxStockByBranch();
}
