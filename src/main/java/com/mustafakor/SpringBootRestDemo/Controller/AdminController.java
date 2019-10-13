package com.mustafakor.SpringBootRestDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustafakor.SpringBootRestDemo.Entity.Producer;
import com.mustafakor.SpringBootRestDemo.Entity.User;
import com.mustafakor.SpringBootRestDemo.Service.ProducerService;
import com.mustafakor.SpringBootRestDemo.Service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping("/test-admin")
	public String testAdmin() {
		return "test admin";
	}
	
	@GetMapping("/list-users")
	public List<User> listUsers(){
		return userService.listAllUsers();
	}
	
	@PostMapping("/save-user")
	public void saveUser(@RequestBody User user) {
		userService.saveUser(user);
	}
	
	@DeleteMapping("/delete-user/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/get-user/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/list-producers")
	public List<Producer> listProducers(){
		return producerService.listAllProducers();
	}
	
	@PostMapping("/save-producer")
	public void saveProducer(@RequestBody Producer producer) {
		producerService.saveProducer(producer);
	}
	
	@DeleteMapping("/delete-producer/{id}")
	public void deleteProducer(@PathVariable int id) {
		producerService.removeProducer(id);
	}
	
	@GetMapping("/get-producer/{id}")
	public Producer getProducer(@PathVariable int id) {
		return producerService.getProducer(id);
	}
	
}
