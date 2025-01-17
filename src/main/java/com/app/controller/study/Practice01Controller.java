package com.app.controller.study;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.DrinkItem;

@Controller
public class Practice01Controller {

	
	///prac01/request1?item=americano&type=coffee 
	
	@RequestMapping("/prac01/request1-1")   //
	public String request1_1(HttpServletRequest request){
		System.out.println("/request1-1");
		System.out.println(request.getParameter("item"));
		System.out.println(request.getParameter("type"));
		
		return "practice/prac01";
	}
	
	@RequestMapping("/prac01/request1-2")   //
	public String request1_2(@RequestParam String item, @RequestParam String type ){
		System.out.println("/request1-2");
		System.out.println(item);
		System.out.println(type);
		
		return "practice/prac01";
	}
	
	@RequestMapping("/prac01/request1-3")   //
	public String request1_3(@RequestParam Map<String, String> paramMap){
		System.out.println("/request1-3");
		System.out.println(paramMap.get("item"));
		System.out.println(paramMap.get("type"));
		
		return "practice/prac01";
	}
	
	@RequestMapping("/prac01/request1-4")   //
	public String request1_4(@ModelAttribute DrinkItem drinkItem){
		System.out.println("/request1-4");
		System.out.println( drinkItem.getItem() );
		System.out.println( drinkItem.getType() );
		
		return "practice/prac01";
	}
	
	
	@RequestMapping("/prac01/viewData1-1")
	public String viewData1_1(HttpServletRequest request) {
		
		request.setAttribute("item", "카페라떼");
		request.setAttribute("type", "커피");
		
		return "practice/prac01";
	}
	
	
	@RequestMapping("/prac01/viewData1-2")
	public String viewData1_2(Model model) {
		
		model.addAttribute("item", "원조커피");
		model.addAttribute("type", "커피음료");
		
		return "practice/prac01";
	}
	
	@RequestMapping("/prac01/viewData1-3")
	public ModelAndView viewData1_3() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("practice/prac01");
		
		mav.addObject("item", "초코라떼");
		mav.addObject("type", "초코음료");
		
		return mav;
	}
	
	
	@RequestMapping("/prac01/viewData1-4")
	public String viewData1_4(Model model) {
		
		model.addAttribute("item", "원조커피");
		model.addAttribute("type", "커피음료");
		
		DrinkItem drinkItem = new DrinkItem();
		drinkItem.setItem("유자차");
		drinkItem.setType("Tea");
		
		model.addAttribute("drinkItem", drinkItem);
		
		return "practice/prac01";
	}
	
	
}
