package com.group6.ntss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group6.ntss.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

	
}