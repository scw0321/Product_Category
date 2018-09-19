package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	List <Category> findAll();

}
