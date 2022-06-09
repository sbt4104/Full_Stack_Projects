package com.natwest.PortfolioMicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.natwest.PortfolioMicroservice.model.User;

@Repository
public interface UserRepo extends MongoRepository<User,String> {

}
