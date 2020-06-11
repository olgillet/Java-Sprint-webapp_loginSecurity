package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByName(String name);
	
}
