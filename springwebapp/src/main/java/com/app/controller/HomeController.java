package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	@RequestMapping("/home")
	//public String home(@RequestParam String username, Model model) {
	public String home(Model model) {
		System.out.println("OK, Spring controller Home");
		//model.addAttribute("user", username);
		return "home";
	}
}
