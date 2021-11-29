package com.erik.project.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erik.project.entities.User;
import com.erik.project.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	
	public UserService() {
	}

	//--------------------------------------------------//
	
	public void saveItem( User user) {

		userRepository.save(user);
	}
	
	public User findById( Integer id) {

		Optional<User> userOpt= userRepository.findById( id );
		
		if( userOpt.isPresent() ){
			
			User user = userOpt.get();
			return user;
		}
		
		return null;
	}

}