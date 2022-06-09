package com.natwest.bankservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.natwest.bankservice.model.Bank;

@Repository
public interface BankRepo extends MongoRepository<Bank,String>
{
	

}
