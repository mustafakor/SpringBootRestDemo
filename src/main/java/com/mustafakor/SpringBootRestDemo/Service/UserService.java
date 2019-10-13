package com.mustafakor.SpringBootRestDemo.Service;

import java.util.List;

import com.mustafakor.SpringBootRestDemo.Entity.User;

public interface UserService {
	public List<User> listAllUsers();
	public void saveUser(User user);
	public User getUser(int id);
	public User getUserByEmail(String Email);
	public void deleteUser(int id);
}
