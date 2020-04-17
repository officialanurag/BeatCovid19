package com.covid.user.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.covid.user.model.User;

public interface UserRepository extends MongoRepository<User, String>  {



}
