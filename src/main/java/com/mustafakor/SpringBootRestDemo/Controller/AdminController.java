package com.mustafakor.SpringBootRestDemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/test-admin")
	public String testAdmin() {
		return "test admin";
	}
	
}
