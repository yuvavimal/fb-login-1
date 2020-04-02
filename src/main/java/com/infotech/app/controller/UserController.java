package com.infotech.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.infotech.app.model.User;

import com.infotech.app.repos.UserRepos;
import com.infotech.app.service.UserService;


@Controller
@RequestMapping(value="/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	
	@Autowired UserRepos userRepos;
	
	@GetMapping(value = "/createuser")
	public ModelAndView createUserView() {
		ModelAndView modelAndView = new ModelAndView("createuser");
		modelAndView.addObject("user", new User());
		modelAndView.addObject("allProfiles", getProfiles());
		return modelAndView;
	}

	@PostMapping("/createuser")
	public ModelAndView createUser(@Valid User user, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("Validation errors while submitting form.");
			modelAndView.setViewName("createuser");
			modelAndView.addObject("user", user);
			modelAndView.addObject("allProfiles", getProfiles());
			return modelAndView;
		}
		userService.addUser(user);
		modelAndView.addObject("allUsers", userService.getAllUsers());
		modelAndView.setViewName("userinfo");
		User userObj = new User();
		//userObj.setUserId("1000");
		userObj.setGender(user.getGender());
		userObj.setMarried(user.getMarried());
		userObj.setProfile(user.getProfile());
		userObj.setUserName(user.getUserName());
		userObj.setPassword(user.getPassword());
	userObj.setEmail(user.getEmail());
		userRepos.save(userObj);
		logger.info("Form submitted successfully.");
		return modelAndView;
	}

	private List<String> getProfiles() {
		List<String> list = new ArrayList<>();  
		
		list.add("Associate");
		list.add("developer");
		list.add("team leader");
		list.add("Director");
		list.add("designer");
		return list;
	}
	
	@GetMapping("/index")
	    public String loginPage() {
			return "index.html";
		}
	

}
