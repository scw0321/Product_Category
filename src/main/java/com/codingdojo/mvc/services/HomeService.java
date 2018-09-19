package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Category;

import com.codingdojo.mvc.models.Product;
import com.codingdojo.mvc.repositories.CategoryRepository;
import com.codingdojo.mvc.repositories.ProductRepository;

@Service
public class HomeService {

	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;



public HomeService(ProductRepository productRepo, CategoryRepository categoryRepo) {
	this.productRepo = productRepo;
	this.categoryRepo = categoryRepo;
}
public Product createProduct(Product p) {
	return productRepo.save(p);
}
public Category createCategory(Category c) {
	return categoryRepo.save(c);
}
public Product findProduct(Long id) {
	Optional<Product> optionalProduct = productRepo.findById(id);
    if(optionalProduct.isPresent()) {
    	Product p = optionalProduct.get();
        return p;
    } else {
        return null;
    }        
}

public Category findCategory(Long id) {
	Optional<Category> optionalCategory = categoryRepo.findById(id);
    if(optionalCategory.isPresent()) {
    	Category c = optionalCategory.get();
        return c;
    } else {
        return null;
    }        
}
public List<Category> findAllCategory() {
	// TODO Auto-generated method stub
	return categoryRepo.findAll();
}
public List<Product> findAllProduct() {
	// TODO Auto-generated method stub
	return productRepo.findAll();
}
}