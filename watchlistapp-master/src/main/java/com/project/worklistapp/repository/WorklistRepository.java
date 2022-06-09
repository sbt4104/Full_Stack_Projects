package com.project.worklistapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.worklistapp.model.Worklist;

@Repository
public interface WorklistRepository extends MongoRepository<Worklist,String> {
	
List<String> findByUserid(String userid);

}
