package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	@GetMapping("/re/re1")
	public String re1() {
		
		return "re/re1";
		
	}
	
	@GetMapping("/re/re2")
	public String re2(HttpServletRequest request) {
		
		System.out.println(request.getParameter("msg"));
		
		// 로직
		request.setAttribute("msg", "re2 직접 넣은 msg");
		
		return "re/re2";
		
	}
	
	@GetMapping("/re/re3")
	public String re3(HttpServletRequest request) {
		
		System.out.println(request.getParameter("msg"));
		
		return "re/re2";      	// 요청 re3 -> view re2
		// return "re/re3";			// 요청 re3 -> view re3(redirect)
		
	}
	
	@GetMapping("/re/re4")
	public String re4(HttpServletRequest request, RedirectAttributes re) {
		
		System.out.println(request.getParameter("msg"));
		
		
		request.setAttribute("msg", "re4 redirect msg");
		re.addAttribute("msg", "re4 ra msg");
		
		
		// request.setAttribute("msg", "re4 redirect msg=re4 redirect msg"); // 경로에 파라미터 추가
		
		// return "re/re2"; 				// view 경로    ..../re2.jsp
		return "redirect:/re/re2"; 			// 그 경로로 다시 요청! 요청할 주소!
		
		
		
		// return "/WEB-INF/views/re/re2/jsp";
		// return "redirect:/re/re2"; 
		
	}
	
	@GetMapping("/re/re5")   //forward 인 경우
	public String re5(HttpServletRequest request) {
		
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", "re5 redirect msg");
		
		return "forward:/re/re2"; 
		
	}
	

}
