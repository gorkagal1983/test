package com.sherpa.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.test.domain.User;
import com.sherpa.test.repository.AddressRepository;
import com.sherpa.test.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressRepository userDetailRepository;
	
	public void saveUser(User user){
		userDetailRepository.save(user.getAddress());
		userRepository.save(user);
	}
	
}
