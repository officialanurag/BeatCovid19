package com.covid.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.covid.model.User;

public interface UserRepository extends MongoRepository<User, String>  {

	Optional<User> findByEmail(String email);

	
}
