package com.sherpa.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.test.domain.Master;
import com.sherpa.test.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(Master master){
		userRepository.save(master);
	}

}
