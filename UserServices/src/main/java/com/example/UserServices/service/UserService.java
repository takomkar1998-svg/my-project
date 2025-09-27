package com.example.UserServices.service;

import com.example.UserServices.Model.User;

public interface UserService {
	
	User register(User user);
	User login(String email, String password);

}
