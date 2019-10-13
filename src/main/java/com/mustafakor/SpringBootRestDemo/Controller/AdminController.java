package com.mustafakor.SpringBootRestDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustafakor.SpringBootRestDemo.Entity.User;
import com.mustafakor.SpringBootRestDemo.Service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/test-admin")
	public String testAdmin() {
		return "test admin";
	}
	
	@GetMapping("/list-users")
	public List<User> listUsers(){
		return userService.listAllUsers();
	}
	
}
