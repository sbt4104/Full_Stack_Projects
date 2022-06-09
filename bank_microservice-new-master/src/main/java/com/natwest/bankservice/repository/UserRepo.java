package com.natwest.bankservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.natwest.bankservice.model.User;

@Repository
public interface UserRepo extends MongoRepository<User,String>{

}
