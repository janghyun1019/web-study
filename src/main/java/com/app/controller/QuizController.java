package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller  // annotation 어노테이션
public class QuizController {
	
	
	@GetMapping("/quiz/main")  // 주소창에 보여지는 경로
	public String main() {

		return "/quiz/main";  // 요청경로
	}
	
	@GetMapping("/quiz/product/mouse")
	public String mouse() {

		return "/quiz/product/mouse";
	}
	
	@GetMapping("/quiz/product/keyboard")
	public String keyboard() {

		return "/quiz/product/keyboard";
	}


}