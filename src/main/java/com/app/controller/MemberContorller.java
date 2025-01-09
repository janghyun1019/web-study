package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberContorller {
	
	@GetMapping("/member/signup")
	public String signup() {

		return "/member/signup";
	}

}
