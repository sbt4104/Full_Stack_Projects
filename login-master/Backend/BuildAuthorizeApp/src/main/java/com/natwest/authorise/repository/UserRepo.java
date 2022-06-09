package com.natwest.authorise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.authorise.model.Userprofile;

@Repository
public interface UserRepo extends JpaRepository<Userprofile,String>
{
	Userprofile findByUseridAndPassword(String userid, String password);
}
