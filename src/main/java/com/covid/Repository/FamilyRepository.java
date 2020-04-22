package com.covid.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.covid.model.Family;

public interface FamilyRepository extends MongoRepository<Family, String>{

}
