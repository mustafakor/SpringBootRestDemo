package com.mustafakor.SpringBootRestDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafakor.SpringBootRestDemo.Entity.User;
import com.mustafakor.SpringBootRestDemo.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> listAllUsers() {
		List<User> userList = userRepository.findAll();
		userList.forEach(user->user.setPassword(""));
		return userList;
	}

}
