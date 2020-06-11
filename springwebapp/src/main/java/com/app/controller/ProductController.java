package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.app.model.Product;
import com.app.repository.ProductRepository;
import com.app.validator.ProductValidator;
import com.app.config.AppConfig;

@Controller
@Transactional
@RequestMapping("/product")
public class ProductController {

	@Autowired
    private ProductRepository productRepository;
	
	@GetMapping("/list")
	public String products(Model model) {
		System.out.println("OK, Spring controller Product : list");
		return "product/list";
	}

	@GetMapping({ "/{idProduct}" })
	public String product(@PathVariable(value="idProduct", required=false) int idProduct, Model model) {
		System.out.println("OK, Spring controller Product : detail");
		model.addAttribute("id", idProduct);
		return "product/detail";
	}
	
	@GetMapping("/add")
	public String addProduct(Model model) {
		System.out.println("OK, Spring controller Product : add - Get");
		model.addAttribute("productObject", new Product("GoPro"));
		return "product/add";
	}
	
	@PostMapping("/add")
	//public String processAddProduct(@ModelAttribute("productObject") Product product, Model model) {
	public String processAddProduct(@ModelAttribute("productObject") Product product, BindingResult result, Model model) {
		System.out.println("OK, Spring controller Product : processAdd - Post : name = '" + product.getName() +"', unitPrice = " + product.getUnitPrice());
		
		new ProductValidator().validate(product, result);
		
		if(result.hasErrors()) {
			System.out.println("processAddProduct - Error");
			return "product/add";
		}else {
			// Add product - probably not the best way to do it - would be better to get the bean only once
			/*
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			context.getBeanFactory().createBean(Application.class).addProduct(product.getName(), product.getUnitPrice());
			context.close();
			*/
			// Application removed and simply replaced by 
			productRepository.save(product);
			
			return "product/list";
		}
	}
	
	
	@GetMapping("/edit/{idProduct}")
	public String editProduct(@PathVariable(value="idProduct", required=false) int idProduct, Model model) {
		System.out.println("OK, Spring controller Product : edit");
		model.addAttribute("id", idProduct);
		return "product/edit";
	}
	
	@GetMapping("/delete/{idProduct}")
	public String deleteProduct(@PathVariable(value="idProduct", required=false) int idProduct, Model model) {
		System.out.println("OK, Spring controller Product : delete");
		model.addAttribute("id", idProduct);
		return "product/delete";
	}
	
}