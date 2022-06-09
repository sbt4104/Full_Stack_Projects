package com.natwest.BankMicroservice.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.natwest.BankMicroservice.user.Userprofile;

@Repository
public interface UserRepository extends JpaRepository<Userprofile,String>{

}
