package com.sherpa.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherpa.test.domain.Detail;
import com.sherpa.test.domain.Master;
import com.sherpa.test.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/create/{cp}/{username}")
    public Master createUser(@PathVariable String cp, @PathVariable String username){
       
		Master master = new Master();
		Detail detail = new Detail();
		
		detail.setCp(cp);
		
		master.setUsername(username);
		master.setDetail(detail);
        
		userService.saveUser(master);
		
        return master;
    }
	
}
