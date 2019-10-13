package com.mustafakor.SpringBootRestDemo.Controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mustafakor.SpringBootRestDemo.Entity.User;
import com.mustafakor.SpringBootRestDemo.Repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

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
	public String testUser() {
		return "test user";
	}

	
}
