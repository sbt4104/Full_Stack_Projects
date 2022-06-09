package com.natwest.BankMicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.natwest.BankMicroservice.model.Bank;

@Repository
public interface BankRepo extends MongoRepository<Bank,Long>{

}
