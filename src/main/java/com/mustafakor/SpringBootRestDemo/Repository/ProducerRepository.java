package com.mustafakor.SpringBootRestDemo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mustafakor.SpringBootRestDemo.Entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {
	Optional<Producer> findById(@Param("id") Integer id);
}
