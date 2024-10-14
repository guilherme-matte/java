package com.guilherme.matte.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.matte.userdept.entities.User;
import com.guilherme.matte.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired

	private UserRepository repository;

	@GetMapping
	public List<User> findAll() {
		List<User> result = repository.findAll();
		return result;

	}

	@GetMapping(value = "/id/{id}")
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return result;

	}

	@GetMapping(value = "/name/{name}")
	public List<User> findUsers(@PathVariable String name) {
		List<User> result = repository.findByName(name);
		return result;
	}

	@GetMapping(value = "/department/{departmentId}")
	public List<User> findUsersByDepartment(@PathVariable int departmentId){
		List<User> result = repository.findByDepartmentId(departmentId);
		return result;
	}
	

	@PostMapping
	public User insert(@RequestBody User user) {
		User result = repository.save(user);
		return result;

	}
}
