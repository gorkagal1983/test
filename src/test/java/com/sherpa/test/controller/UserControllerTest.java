package com.sherpa.test.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.sherpa.test.Application;
import com.sherpa.test.domain.User;
import com.sherpa.test.model.ErrorResponse;
import com.sherpa.test.repository.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class UserControllerTest {
	
	@Autowired
	private UserRepository userRepository;
	
	private User user;

	private RestTemplate restTemplate = new TestRestTemplate();
    
	@After
	public void after(){
		userRepository.delete(user.getId());
	}
	
    @Test
    public void testRestApiCreateUser() throws Exception {
    	user = new User();
    	
    	User userResponse = restTemplate.getForObject("http://localhost:8080/users/create/48015/usernameTest", User.class);
    	user.setId(userResponse.getId());
    	
    	Assert.assertTrue(userResponse.getUsername().equals("usernameTest"));
    }
    
    @Test
    public void testCreateUniqueUser() throws Exception {
    	user = new User();
    	user.setUsername("usernameTest");
    	
    	userRepository.save(user);
    	ErrorResponse error = restTemplate.getForObject("http://localhost:8080/users/create/48015/usernameTest", ErrorResponse.class);
     	
    	Assert.assertTrue(error.getMessage().equals("Ya existe el usuario registrado en el sistema"));
    }
    
    
}
