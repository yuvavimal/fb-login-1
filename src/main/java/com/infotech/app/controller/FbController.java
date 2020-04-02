package com.infotech.app.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class FbController {
	
    @GetMapping
    public Principal getUser(Principal users) {
        return users;
        	
}
   
}