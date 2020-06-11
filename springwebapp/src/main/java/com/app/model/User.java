package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Length(min = 5, message = "User name should contain at least 5 characters")
	String name;

	@Length(min = 5, message = "User password should contain at least 5 characters")
	String password;
	
	@Transient
	String passwordConfirmation;
	
	public User() {
	}
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public User(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
}
