package com.covid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid.Repository.UserRepository;
import com.covid.model.LoginForm;
import com.covid.model.User;
import com.covid.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService service;
@PostMapping("/create")
public User create(@RequestBody User user) {
	return service.create(user);

	}

@GetMapping("/{user_id}")
public User findUser_id(@PathVariable("user_id") String user_id) {
return service.findUser(user_id);		
}

@PostMapping("/login")
public User login(@RequestBody LoginForm login) {
	System.out.println("hello world");
	System.out.println(login);
return service.findByEmail(login);

}

	

}
