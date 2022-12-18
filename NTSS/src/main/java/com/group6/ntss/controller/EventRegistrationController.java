package com.group6.ntss.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group6.ntss.dao.EventRepositry;
import com.group6.ntss.dao.UserEventRegisterRepository;
import com.group6.ntss.model.Event;
import com.group6.ntss.model.UserRegisteredEvents;
import com.group6.ntss.util.DbManager;

@Controller
@RequestMapping(path="/event")
public class EventRegistrationController {
	
  @Autowired
  DbManager manager = DbManager.getInstance();

  @Autowired
  private UserEventRegisterRepository user_event_repository; 

  @PostMapping(path="/add")
  public @ResponseBody String addNewEvent (@RequestParam String event_name
      , @RequestParam String theme
      , @RequestParam String slogan
      , @RequestParam String location
      , @RequestParam String duration) {

    Event e = new Event();
    e.setEvent_name(event_name);
    e.setTheme(theme);
    e.setSlogan(slogan);
    e.setLocation(location);
    e.setDuration(duration);
    manager.createEvent(e);
    return "home";
  }
  
  @GetMapping(path="/get-events")
  public ModelAndView getAllEvents () {
	  
    List<Event> eventsList = manager.findAllEvents();
	ModelAndView modelAndView = new ModelAndView("list-events");
    modelAndView.addObject("eventsList", eventsList);
    
	
    return modelAndView;
  }
  
  @RequestMapping(path="/register", method = RequestMethod.POST)
  public String registerForEvent (Event event, HttpServletRequest request) {
	 
	  UserRegisteredEvents userEvent = new UserRegisteredEvents();
	  userEvent.setEvent_id(event.getId());
	  userEvent.setUser_id(Long.parseLong(String.valueOf(request.getSession().getAttribute("userId"))));
	  
	  user_event_repository.save(userEvent);
	  
	  System.out.println("Eventname" +  event.getId());
    return "";
  }
  
  @GetMapping("")
	public String dummy() {		
		return "event";
	}
}