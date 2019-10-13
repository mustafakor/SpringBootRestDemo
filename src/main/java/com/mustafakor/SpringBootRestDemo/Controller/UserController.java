package com.mustafakor.SpringBootRestDemo.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mustafakor.SpringBootRestDemo.Entity.User;
import com.mustafakor.SpringBootRestDemo.Repository.UserRepository;
import com.mustafakor.SpringBootRestDemo.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public void signUp(@RequestBody User user) {
		user.setPassword(bCryptPasswordEncoder.encode((user.getPassword())));
		userRepository.save(user);
	}
	
	@GetMapping("/test-user")
	public User testUser(Principal principal, Authentication authentication) {
		String username = principal.getName();
		User user = userService.getUserByEmail(username);
		return user;
	}

	
}
