package com.mustafakor.SpringBootRestDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mustafakor.SpringBootRestDemo.Entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(@Param("email") String email);

}
