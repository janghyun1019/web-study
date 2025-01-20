package com.app.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.app.service.user.UserService;

@Controller
public class CustomerController {
	
	@Autowired
	UserService userService;
}
