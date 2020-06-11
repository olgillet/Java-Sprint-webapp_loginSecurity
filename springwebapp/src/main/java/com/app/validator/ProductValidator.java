package com.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.Product;


public class ProductValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls) {
		return Product.class.equals(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "product.name.empty", "Fill the product's name please");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unitPrice", "product.unitPrice.empty", "Fill the product's unit price please");
		
		Product product = (Product) obj;
		System.out.println("-"+product.toString()+"-");
		
		if(product.getUnitPrice() != null) {
			if(product.getUnitPrice() <=0 || product.getUnitPrice() > 1000){
				errors.rejectValue("unitPrice", "product.unitPrice.wrongValue", new Object[]{"'unitPrice'"}, "Invalid Unit Price (must be between 0 and 1000)");
			}
		}
	}
}