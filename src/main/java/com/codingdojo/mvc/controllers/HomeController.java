package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Category;

import com.codingdojo.mvc.models.Product;
import com.codingdojo.mvc.services.HomeService;

@Controller
public class HomeController {
	
	private final HomeService homeService;
	
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("product") Product product, @ModelAttribute("category") Category category) {
		List<Product> allProduct = homeService.findAllProduct();
		List<Category> allCategory = homeService.findAllCategory();
		model.addAttribute("product", allProduct);
		model.addAttribute("category", allCategory);
		
		return "index.jsp";
		
	}
	@GetMapping("/products/new")
	public String index(@ModelAttribute("product") Product product) {
		
		return "product.jsp";
	}
	@PostMapping("/products/create")
	public String createProduct(@Valid @ModelAttribute("product") Product p, BindingResult result) {
        if (result.hasErrors()) {
            return "product.jsp";
        } else {
            homeService.createProduct(p);
            return "redirect:/products/new";
        }
    }

	@GetMapping("/categories/new")
	public String index(@ModelAttribute("category") Category c) {
		
		return "category.jsp";
	}
	@PostMapping("/categories/create")
	public String createCategory(@Valid @ModelAttribute("category") Category c, BindingResult result) {
        if (result.hasErrors()) {
            return "category.jsp";
        } else {
            homeService.createCategory(c);
            return "redirect:/categories/new";
        }
    }
	@RequestMapping("products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		List<Category> allCategory = homeService.findAllCategory();
		model.addAttribute("category", allCategory);
		Product theProduct = homeService.findProduct(id);                
		model.addAttribute("product", theProduct);
        return "showProduct.jsp";
	
	}
	@RequestMapping("categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		List<Product> allProduct = homeService.findAllProduct();
		model.addAttribute("product", allProduct);
		Category myCategory = homeService.findCategory(id);                
		model.addAttribute("dojo", myCategory);
        return "showCategory.jsp";
	
	}

}
