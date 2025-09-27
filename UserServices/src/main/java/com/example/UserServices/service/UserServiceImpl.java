package com.example.UserServices.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.UserServices.Model.User;
import com.example.UserServices.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	
	 private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	

	@Override
	public User register(User user) {
	
		Optional<User> existingUser= userRepository.findByEmail(user.getEmail());
		if(existingUser.isPresent()){
			throw new RuntimeException("Email already registered");
		}
		return userRepository.save(user);
	}

	@Override
	public User login(String email, String password) {
		Optional<User> user = userRepository.findByEmail(email);
		
		if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        } else {
            throw new RuntimeException("Invalid email or password");
        }
	}

}
