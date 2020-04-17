package com.covid.user.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.user.Autogenerators.Autogenerate;
import com.covid.user.Repository.UserRepository;
import com.covid.user.model.User;

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


}
