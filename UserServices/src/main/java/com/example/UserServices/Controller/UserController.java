package com.example.UserServices.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserServices.Model.User;
import com.example.UserServices.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	 private final UserService userService;
	
	
	public UserController(UserService userService) {
        this.userService = userService;
    }
	
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
		
	}
	
	@PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }

}
