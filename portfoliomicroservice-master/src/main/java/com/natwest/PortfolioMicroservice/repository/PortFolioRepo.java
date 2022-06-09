package com.natwest.PortfolioMicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.natwest.PortfolioMicroservice.model.PortFolio;

@Repository
public interface PortFolioRepo extends MongoRepository<PortFolio,String>{

}
