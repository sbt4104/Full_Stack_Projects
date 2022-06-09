package com.sample.authorizeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.authorizeapp.model.Userprofile;

@Repository
public interface UserprofileRepository extends JpaRepository<Userprofile,String> {

	Userprofile findByUseremailAndPassword(String useremail, int password);
	
}
