package com.app.controller.study;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.Quiz05Request;
import com.app.dto.study.ResponseItem;

@Controller
public class Quiz05Controller {

	@GetMapping("/quiz05/request1-1")
	public String request1_1(HttpServletRequest request){
		
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));
		
		return "quiz/quiz05/quiz05";
	}
	
	@GetMapping("/quiz05/request1-2")
	public String request1_2(@RequestParam String category, @RequestParam String product){
		
		System.out.println(category);
		System.out.println(product);
		
		return "quiz/quiz05/quiz05";
	}
	
	@GetMapping("/quiz05/request1-3")
	public String request1_3(@ModelAttribute Quiz05Request quiz05Request){
		System.out.println(quiz05Request.getCategory());
		System.out.println(quiz05Request.getProduct());
		
		return "quiz/quiz05/quiz05";
	}
	
	@GetMapping("/quiz05/request1-4")
	public String request1_4(@RequestParam Map<String, String> paramMap){
		System.out.println(paramMap.get("category"));
		System.out.println(paramMap.get("product"));	
		
		return "quiz/quiz05/quiz05";
	}
	
	@GetMapping("/quiz05/response1-1")
	public String response1_1(HttpServletRequest request) {
		request.setAttribute("response001", "message");
		request.setAttribute("response099", "아무거나");
		
		return "quiz/quiz05/quiz05";
	}
	
	@GetMapping("/quiz05/response1-2")
	public String response1_2(Model model) {
		model.addAttribute("response001", "message1-2");
		model.addAttribute("response099", "아무거나1-2");
		
		return "quiz/quiz05/quiz05";
	}
	
	@GetMapping("/quiz05/response1-3")
	public ModelAndView response1_3() {
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("quiz/quiz05/quiz05");
		
		ModelAndView mav = new ModelAndView("quiz/quiz05/quiz05");
		mav.addObject("response001", "res001 1-3");
		mav.addObject("response099", "res099 1-3");
		
		return mav;
	}
	
	@GetMapping("/quiz05/response1-4")
	//public String response1_4(ResponseItem responseItem) {		//@ModelAttribute 어노테이션 생략가능
	//public String response1_4(@ModelAttribute ResponseItem responseItem) {
	public String response1_4(Model model) {		//@ModelAttribute 어노테이션 생략가능
		
		ResponseItem responseItem = new ResponseItem();
		System.out.println(responseItem.getResponse001());
		System.out.println(responseItem.getResponse099());
		
		responseItem.setResponse001("1-4 item 001");
		responseItem.setResponse099("1-4 객체 099변수전달");
		
		model.addAttribute("responseItem", responseItem);
		
		return "quiz/quiz05/quiz05";
	}
}
