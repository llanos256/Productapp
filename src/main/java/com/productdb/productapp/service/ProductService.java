package com.productdb.productapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productdb.productapp.models.Branch;
import com.productdb.productapp.models.BranchDto;
import com.productdb.productapp.models.Franchise;
import com.productdb.productapp.models.NameBody;
import com.productdb.productapp.models.Product;
import com.productdb.productapp.models.ProductBody;
import com.productdb.productapp.models.ProductDto;
import com.productdb.productapp.models.StockBody;
import com.productdb.productapp.repositories.BranchRepository;
import com.productdb.productapp.repositories.FranchiseRepository;
import com.productdb.productapp.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
    
	@Autowired
	private FranchiseRepository francRepo;
	
	@Autowired
	private BranchRepository branchRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@Transactional
	public Franchise createFranchise(NameBody body) {
		Franchise franchise = new Franchise();
		franchise.setName(body.getName());
		franchise = francRepo.save(franchise);
		return franchise;
	}
	
	@Transactional
	public BranchDto createBranch(Long franchiseId, NameBody body) {
		Franchise franchise = francRepo.getReferenceById(franchiseId);
		if (franchise == null) {
			throw new RuntimeException("Franchise with id "+ franchiseId + " was not found");
		}
		Branch branch = new Branch();
		branch.setName(body.getName());
		branch.setFranchise(franchise);
		branch = branchRepo.save(branch);
		BranchDto branchdto = new BranchDto();
		branchdto.setId(branch.getId());
		branchdto.setName(branch.getName());
		branchdto.setFranchiseId(branch.getFranchise().getId());
		return branchdto;
	}
	
	@Transactional
	public ProductDto createProduct(Long branchId, ProductBody body) {
		Branch branch = branchRepo.getReferenceById(branchId);
		if (branch == null) {
			throw new RuntimeException("Branch with id "+ branchId + " was not found");
		}
		Product product = new Product();
		product.setName(body.getName());
		product.setStock(body.getStock());
		product.setBranch(branch);
		product= productRepo.save(product);
		ProductDto productdto = new ProductDto();
		productdto.setId(product.getId());
		productdto.setName(product.getName());
		productdto.setStock(product.getStock());
		productdto.setBranchId(product.getBranch().getId());
		productdto.setBranchName(product.getBranch().getName());
		return productdto;
	}
	
	@Transactional
	public String deleteProduct(Long productId) {
		Product product = productRepo.getReferenceById(productId);
		if (product == null) {
			throw new RuntimeException("Product with id "+ productId + " was not found");
		}
		productRepo.delete(product);
		final String deleteM = "Product with id "+ productId + " was deleted";
		return deleteM;
	}
	
	@Transactional
	public ProductDto updateStock(Long productId, StockBody body) {
		Product product = productRepo.getReferenceById(productId);
		if (product == null) {
			throw new RuntimeException("Product with id "+ productId + " was not found");
		}
		product.setStock(body.getStock());
		product = productRepo.save(product);
		ProductDto productdto = new ProductDto();
		productdto.setId(product.getId());
		productdto.setName(product.getName());
		productdto.setStock(product.getStock());
		productdto.setBranchId(product.getBranch().getId());
		productdto.setBranchName(product.getBranch().getName());
		return productdto;
	}
	
	@Transactional
	public List<ProductDto> productsWithHighestStock() {
		List<Product> productList = productRepo.findProductsWithMaxStockByBranch();
		List<ProductDto> productdtoList = new ArrayList<ProductDto>();
		if (productList != null && !productList.isEmpty()) {
			for (Product product : productList) {
				ProductDto productdto = new ProductDto();
				productdto.setId(product.getId());
				productdto.setName(product.getName());
				productdto.setStock(product.getStock());
				productdto.setBranchId(product.getBranch().getId());
				productdto.setBranchName(product.getBranch().getName());
				productdtoList.add(productdto);
			}
		}
		return productdtoList;
	}
	
	@Transactional
	public Franchise updateName(Long franchiseId, NameBody body) {
		Franchise franchise = francRepo.getReferenceById(franchiseId);
		if (franchise == null) {
			throw new RuntimeException("Franchise with id "+ franchiseId + " was not found");
		}
		franchise.setName(body.getName());
		franchise = francRepo.save(franchise);
		return franchise;
	}
	
	@Transactional
	public BranchDto updateBranchName(Long branchId, NameBody body) {
		Branch branch = branchRepo.getReferenceById(branchId);
		if (branch == null) {
			throw new RuntimeException("Branch with id "+ branchId + " was not found");
		}
		branch.setName(body.getName());
		branch = branchRepo.save(branch);
		BranchDto branchdto = new BranchDto();
		branchdto.setId(branch.getId());
		branchdto.setName(branch.getName());
		branchdto.setFranchiseId(branch.getFranchise().getId());
		return branchdto;
	}
	
	@Transactional
	public ProductDto updateProductName(Long productId, NameBody body) {
		Product product = productRepo.getReferenceById(productId);
		if (product == null) {
			throw new RuntimeException("Product with id "+ productId + " was not found");
		}
		product.setName(body.getName());
		product = productRepo.save(product);
		ProductDto productdto = new ProductDto();
		productdto.setId(product.getId());
		productdto.setName(product.getName());
		productdto.setStock(product.getStock());
		productdto.setBranchId(product.getBranch().getId());
		productdto.setBranchName(product.getBranch().getName());
		return productdto;
	}
}
