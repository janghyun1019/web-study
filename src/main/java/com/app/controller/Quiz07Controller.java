package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Quiz07Controller {

	
	//기본 버전
//	@GetMapping("/scopeCheck/first")
//	public String first(Model model) {
//		model.addAttribute("accessUrl", "/first");
//		return "quiz/quiz07/targetPage";
//	}
	
	@GetMapping("/scopeCheck/first")
	public String first(Model model, HttpSession session) {
		
		//firsthide2 접근 -> redirect -> session  accessUrl : "/firsthide2"
		
		System.out.println(session.getAttribute("accessUrl"));
		if(session.getAttribute("accessUrl") == null) { // /first 로 바로 왔다
			model.addAttribute("accessUrl", "/first");
		} else {  // session accessUrl 있다 -> firsthide2 를 들렸다가 왔다
			//model.addAttribute("accessUrl", "/firsthide2");
			model.addAttribute("accessUrl", session.getAttribute("accessUrl"));
			session.removeAttribute("accessUrl");
		}
		
		//request scope 삭제 -> session scope 인식
		//session scope -> request scope 이동 시켜서 request 가 자동으로 인식
		
		return "quiz/quiz07/targetPage";
	}
	
	@GetMapping("/scopeCheck/firsthide1")
	public String firsthide1(Model model) {
		model.addAttribute("accessUrl", "/firsthide1");
		return "quiz/quiz07/targetPage";
	}
	
	//기본 버전
//	@GetMapping("/scopeCheck/firsthide2")
//	public String firsthide2() {
//		
//		return "redirect:/scopeCheck/first";
//	}
	
	@GetMapping("/scopeCheck/firsthide2")
	public String firsthide2(HttpServletRequest request) {
		//request.setAttribute("accessUrl", "/firsthide2");
		HttpSession session =  request.getSession();
		session.setAttribute("accessUrl", "/firsthide2");
		
		return "redirect:/scopeCheck/first";
	}
	
	@GetMapping("/scopeCheck/firsthide3")
	public String firsthide3(HttpServletRequest request) {
		HttpSession session =  request.getSession();
		session.setAttribute("accessUrl", "/firsthide3");
		
		return "redirect:/scopeCheck/first";
	}
	
	
	
}
