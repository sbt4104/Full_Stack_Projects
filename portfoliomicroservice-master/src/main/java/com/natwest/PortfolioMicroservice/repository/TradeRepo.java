package com.natwest.PortfolioMicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.natwest.PortfolioMicroservice.model.Trade;

@Repository
public interface TradeRepo extends MongoRepository<Trade,String>{

}
