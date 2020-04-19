package com.covid.user.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.covid.user.model.User;

public interface UserRepository extends MongoRepository<User, String>  {

	Optional<User> findByEmail(String email);

	
}
