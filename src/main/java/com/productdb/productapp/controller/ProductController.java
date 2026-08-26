package com.productdb.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productdb.productapp.models.BranchDto;
import com.productdb.productapp.models.Franchise;
import com.productdb.productapp.models.NameBody;
import com.productdb.productapp.models.ProductBody;
import com.productdb.productapp.models.ProductDto;
import com.productdb.productapp.models.StockBody;
import com.productdb.productapp.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class ProductController {
      
	@Autowired
	private ProductService productService;
	
	
	@PostMapping(value = "/franchise")
	@Operation(summary = "Add a new franchise")
	public ResponseEntity<Franchise> createFranchise(@RequestBody NameBody body) {
		return ResponseEntity.ok(productService.createFranchise(body));
	}
	
	@PostMapping(value = "/{franchiseId}/branch")
	@Operation(summary = "Add a new branch to a franchise")
	public ResponseEntity<BranchDto> createBranch(@PathVariable Long franchiseId, @RequestBody NameBody body) {
		return ResponseEntity.ok(productService.createBranch(franchiseId, body));
	}
	
	@PostMapping(value = "/{branchId}/product")
	@Operation(summary = "Add a new product to a branch")
	public ResponseEntity<ProductDto> createProduct(@PathVariable Long branchId, @RequestBody ProductBody body) {
		return ResponseEntity.ok(productService.createProduct(branchId, body));
	}
	
	@DeleteMapping(value = "/{productId}")
	@Operation(summary = "Delete a product")
	public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
		return ResponseEntity.ok(productService.deleteProduct(productId));
	}
	
	@PutMapping(value = "/{productId}/stock")
	@Operation(summary = "Update a product stock")
	public ResponseEntity<ProductDto> updateStock(@PathVariable Long productId, @RequestBody StockBody body) {
		return ResponseEntity.ok(productService.updateStock(productId, body));
	}
	
	@GetMapping(value = "/higheststockbybranch")
	@Operation(summary = "List products with highest stock by branch")
	public ResponseEntity<List<ProductDto>> highestStockByBranch() {
		return ResponseEntity.ok(productService.productsWithHighestStock());
	}
	
	@PutMapping(value = "/{franchiseId}/franchise")
	@Operation(summary = "Update a franchise name")
	public ResponseEntity<Franchise> updateFranchiseName(@PathVariable Long franchiseId, @RequestBody NameBody body) {
		return ResponseEntity.ok(productService.updateName(franchiseId, body));
	}
	
	@PutMapping(value = "/{branchId}/branch")
	@Operation(summary = "Update a branch name")
	public ResponseEntity<BranchDto> updateBranchName(@PathVariable Long branchId, @RequestBody NameBody body) {
		return ResponseEntity.ok(productService.updateBranchName(branchId, body));
	}
	
	@PutMapping(value = "/{productId}/product")
	@Operation(summary = "Update a product name")
	public ResponseEntity<ProductDto> updateProductName(@PathVariable Long productId, @RequestBody NameBody body) {
		return ResponseEntity.ok(productService.updateProductName(productId, body));
	}
}
