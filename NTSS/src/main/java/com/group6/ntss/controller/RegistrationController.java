package com.group6.ntss.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group6.ntss.dao.UserRepository;
import com.group6.ntss.model.User;
import com.group6.ntss.util.DbManager;

@Controller
public class RegistrationController  {
	
	@Autowired
	DbManager manager = DbManager.getInstance();
			
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		System.out.println("Session data" + request.getSession().getAttribute("userId"));
		return "home";
	}
	
	@GetMapping("/signup")
	public String getUserDetails() {		
		return "signup";
	}

	@PostMapping(path ="/signup")
	public ModelAndView registerUser(User user)
	{
	    
		ModelAndView modelAndView = new ModelAndView("signup");
		
		List<User> usersList = manager.findAllUsers();
		Iterator<User> iter = usersList.iterator();
		boolean isUserDoesNotExist = true;
		
		while(iter.hasNext())
		{
			

			User newUser = iter.next();
			
			if(newUser!= null && user.getEmail().equalsIgnoreCase(newUser.getEmail()))
			{				
				isUserDoesNotExist = false;
				modelAndView.addObject("signUpSuccess","User Already Exists");

			}
		}		
		if(isUserDoesNotExist)
		{
			manager.createUser(user);
			modelAndView.addObject("signUpSuccess","User Succesfully Registered");
		}
		return modelAndView;
	}
	
	

	
	

}
