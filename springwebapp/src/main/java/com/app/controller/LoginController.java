package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;

@Controller
public class LoginController {
    
	@ModelAttribute("user")
    public User initUser(){
        return new User();
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model, @RequestParam(required = false) boolean error){
        model.addAttribute("error", error);
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model){
        System.out.println(model.getAttribute("username"));
        System.out.println(model.getAttribute("password"));
        return "home";
    }
}