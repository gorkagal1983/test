package com.sherpa.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sherpa.test.domain.Address;
import com.sherpa.test.domain.User;
import com.sherpa.test.model.ErrorResponse;
import com.sherpa.test.service.UserService;
import com.sherpa.test.utilities.CustomException;
import com.sherpa.test.utilities.GeonamesRestAPI;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/create/{cp}/{username}",method = RequestMethod.GET)
    public User createUser(@PathVariable String cp,@PathVariable String username) throws Exception{
       
	    User user = new User();
		Address address = new Address();
	
		address.setCp(cp);
		GeonamesRestAPI geonamesApi = new GeonamesRestAPI();
		String city = geonamesApi.getCityByPostalCode(cp);
		if (city == null){
			throw new CustomException("No existe una ciudad para el código postal: " + cp);
		}
		address.setCity(city);
		
		user.setUsername(username);
		user.setAddress(address);
        
		userService.saveUser(user);
	
        return user;
    }
	
	@ExceptionHandler(Exception.class)
	public ErrorResponse myError(HttpServletRequest request, Exception exception) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST);
	    error.setMessage("Se ha producido un error al procesar la request: " + exception.getMessage());
	    error.setUrl(request.getRequestURL().toString());
	    return error;
	}
	
	@ExceptionHandler(CustomException.class)
	public ErrorResponse myError(HttpServletRequest request, CustomException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST);
	    error.setMessage(exception.getMessage());
	    error.setUrl(request.getRequestURL().toString());
	    return error;
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ErrorResponse myError(HttpServletRequest request, DataIntegrityViolationException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST);
	    error.setMessage("Ya existe el usuario registrado en el sistema");
	    error.setUrl(request.getRequestURL().toString());
	    return error;
	}
}
