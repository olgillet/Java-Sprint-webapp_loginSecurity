package com.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.User;


public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls) {
		return User.class.equals(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "user.name.empty", "Fill the user's name please");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password.empty", "Fill the user's password please");
		
		// Check if password from the Form is equal to the password from DB
		// User test, set manually in DB : admin1111/password1111, admin2222/password2222 
		if( ! ((User)obj).getPassword().equals( ((User)obj).getPasswordConfirmation() ) ){
            errors.rejectValue("password", "password.different", "Password incorrect");
        }
		
	}
}