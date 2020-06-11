package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.app.repository.UserRepository;
import com.app.validator.UserValidator;
import com.app.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
    private UserRepository userRepository;
	
	@GetMapping("/login-form")
	public String loginUser(Model model) {
		System.out.println("OK, Spring controller User : login - Get");
		model.addAttribute("userObject", new User("Toto"));
		return "user/login";
	}
	
	@PostMapping("/login-form")
	public String processLoginUser(@Valid @ModelAttribute("userObject") User user, BindingResult result, Model model) {
		System.out.println("OK, Spring controller User : processLoginUser - Post : name = '" + user.getName() +"', password = " + user.getPassword());
		
		new UserValidator().validate(user, result);
		
		if(result.hasErrors()) {
			System.out.println("processAddUser - Error");
			return "user/login";
		}else {
			userRepository.save(user);
			return "product/list";
		}
	}
	
}