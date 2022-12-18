package com.group6.ntss.util;

import com.group6.ntss.model.Event;
import com.group6.ntss.model.User;
import com.group6.ntss.model.UserRegisteredEvents;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.group6.ntss.dao.EventRepositry;
import com.group6.ntss.dao.UserEventRegisterRepository;
import com.group6.ntss.dao.UserRepository;

@Component
public class DbManager {
	
	private static DbManager manager = null;
	
	@Autowired
	private UserRepository user_repo;
	@Autowired
	EventRepositry event_repo;
	@Autowired
	UserEventRegisterRepository user_event_repo;
	
	private DbManager() {} 
	public static DbManager getInstance() {
		if(manager == null)
		{
			manager = new DbManager();
		}
		return manager;
	}
	
	public void createUser(User user) {
		user_repo.save(user);
	}
	
	public User findByEmail(String email)
	{
		return user_repo.findByEmail(email);

	}
	
	public List<User> findAllUsers()
	{
		return user_repo.findAll();
	}
	
	public void createEvent(Event event)
	{
		event_repo.save(event);
	}
	
	public List<Event> findAllEvents()
	{
		return event_repo.findAll();
	}
	
	public void createUserEventRegister(UserRegisteredEvents user_registered_event)
	{
		user_event_repo.save(user_registered_event);
	}
	
	public List<UserRegisteredEvents> findAllUserRegisteredEvents(){
		return user_event_repo.findAll();
	}
}
