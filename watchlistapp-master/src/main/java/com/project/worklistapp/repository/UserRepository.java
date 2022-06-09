package com.project.worklistapp.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.worklistapp.model.User;


@Repository
public interface UserRepository extends MongoRepository<User,String> {

	

}
