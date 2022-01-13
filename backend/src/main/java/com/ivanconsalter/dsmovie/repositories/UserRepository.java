package com.ivanconsalter.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivanconsalter.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
