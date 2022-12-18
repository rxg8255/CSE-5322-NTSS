package com.group6.ntss.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.group6.ntss.dao.UserRepository;
import com.group6.ntss.model.User;
import com.group6.ntss.util.DbManager;

@Controller
public class LoginController {

	@Autowired
	DbManager manager = DbManager.getInstance();
	
	@Autowired
	private WebApplicationContext addContext;
	
	@PostMapping(path = "/login")
	public ModelAndView login(User user, HttpSession session)
	{		
		
		ModelAndView modelAndView = new ModelAndView("login");
		if(user != null && user.getEmail()!= null)
		{
			User newUser = new User();
			newUser = manager.findByEmail(user.getEmail());
			if(newUser!= null && user.getEmail().equalsIgnoreCase(newUser.getEmail()))
			{
				if(user.getPassword().equalsIgnoreCase(newUser.getPassword()))
				{
					System.out.println("Inside getpassword");
					session.setAttribute("userId", newUser.getUserId());
					session.setAttribute("userType", newUser.getUserType());
					modelAndView.addObject("userSuccess","User Succesfully logged In");
					modelAndView.addObject("userEmail", newUser.getEmail());
					return modelAndView;
				}
			}
			else {
				modelAndView.addObject("userSuccess","Authentication Error");
			}
		}
		return modelAndView;
		
	}
	
	@GetMapping(path = "/login")
	public String userLogin()
	{
		System.out.println("email" );
		System.out.println("password");
		System.out.println("id" );
		
		return "login";
		
	}
}
