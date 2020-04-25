package com.covid.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import com.covid.Autogenerators.Autogenerate;
import com.covid.Repository.UserRepository;
import com.covid.model.LoginForm;
import com.covid.model.User;

@Service
public class UserService {
	@Autowired
	UserRepository repos;
	@Autowired
	Autogenerate generate;
	public User create(User user) {	
		user.setCreated_at(new Date());
		String user_id=generate.getuser_id(user);
		String token=generate.getToken();
		user.setCurrent_token(token);
		user.setUser_id(user_id);
	    repos.insert(user);
		return user;
	}


	public User findUser(String User_id) {
		return repos.findById(User_id).orElseThrow(null);
     }

	public User findByEmail(LoginForm login,WebRequest request) {
		String email=login.getEmail();
		String password=login.getPassword();
		User user=repos.findByEmail(email).orElseThrow(null);
		String myPass=user.getPassword();
		if(myPass.equals(password)) {
			user.setCurrent_token(generate.getToken());
			repos.save(user);
			request.setAttribute("user_id",user.getUser_id(), RequestAttributes.SCOPE_SESSION);
			return user;
		} 
		else throw new NullPointerException();
	}



}
