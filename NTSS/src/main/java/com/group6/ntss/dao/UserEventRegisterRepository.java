package com.group6.ntss.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group6.ntss.model.UserRegisteredEvents;

public interface UserEventRegisterRepository extends JpaRepository<UserRegisteredEvents, Long> {
	

	
}