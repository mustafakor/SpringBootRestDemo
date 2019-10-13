package com.mustafakor.SpringBootRestDemo.Service;

import java.util.List;

import com.mustafakor.SpringBootRestDemo.Entity.User;

public interface UserService {
	public List<User> listAllUsers();
}
