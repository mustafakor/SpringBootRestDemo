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

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User getUser(int id) {
		User user = userRepository.getOne(id);
		user.setPassword("");
		return user;
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public User getUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		user.setPassword("");
		return user;
	}

}
