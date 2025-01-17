package com.app.controller.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@RequestMapping("/main")
	public String main() {
		return "quiz/main";
	}
	
	@RequestMapping(value="/product/mouse", method = RequestMethod.GET)
	public String mouse() {
		return "quiz/product/mouse";
	}

	@GetMapping("/product/keyboard")
	public String keyboard() {
		return "quiz/product/keyboard";
	}
	
	
//	@GetMapping("/req1")
	@RequestMapping(value="/req1", method = RequestMethod.GET)
	public String req1Get() {
		System.out.println("/quiz/req1 GET 요청");
		return "quiz/main";
	}
	
//	@PostMapping("/req1")
	@RequestMapping(value="/req1", method = RequestMethod.POST)
	public String req1Post() {
		System.out.println("/quiz/req1 POST 요청");
		return "quiz/main";
	}
	
	@RequestMapping("/req2")
	public String req2(HttpServletRequest request) {
		System.out.println(request.getParameter("data1"));
		System.out.println(request.getParameter("data2"));
		
		request.setAttribute("data1", request.getParameter("data1"));
		request.setAttribute("data2", request.getParameter("data2"));
		return "quiz/main";
	}
}

//@Controller
//public class QuizController {
//
//	@RequestMapping("/quiz/main")
//	public String main() {
//		return "quiz/main";
//	}
//	
//	@RequestMapping(value="/quiz/product/mouse", method = RequestMethod.GET)
//	public String mouse() {
//		return "quiz/product/mouse";
//	}
//
//	@GetMapping("/quiz/product/keyboard")
//	public String keyboard() {
//		return "quiz/product/keyboard";
//	}
//}
