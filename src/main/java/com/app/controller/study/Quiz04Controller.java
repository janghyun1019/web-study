package com.app.controller.study;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.PersonBmi;

@Controller
public class Quiz04Controller {

	//@RequestMapping("/quiz04/ask-bmi")
	@GetMapping("/quiz04/ask-bmi")
	public String ask_bmi() {
		return "quiz/quiz04/ask-bmi";
	}
	
	//@PostMapping("/quiz04/result-bmi")
	@RequestMapping("/quiz04/result-bmi")
	public String result_bmi(@RequestParam String name, 
			@RequestParam String height, 
			@RequestParam String weight,
			Model model) {
		
		Double heightDb = Double.parseDouble(height);
		Double weightDb = Double.parseDouble(weight);
		
		//double bmi = weightDb / (heightDb/100)*(heightDb/100);
		double bmi = weightDb / Math.pow(heightDb/100, 2);
		
		model.addAttribute("name", name);
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		model.addAttribute("bmi", bmi);
		
		
		return "quiz/quiz04/result-bmi";
	}
	
	@RequestMapping("/quiz04/result-bmi2")
	public String result_bmi2(HttpServletRequest request) {
		
		Double heightDb = Double.parseDouble(request.getParameter("height"));
		Double weightDb = Double.parseDouble(request.getParameter("weight"));
		
		//double bmi = weightDb / (heightDb/100)*(heightDb/100);
		double bmi = weightDb / Math.pow(heightDb/100, 2);
		
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("height", request.getParameter("height"));
		request.setAttribute("weight", request.getParameter("weight"));
		request.setAttribute("bmi", bmi);
		
		return "quiz/quiz04/result-bmi";
	}
	
	@RequestMapping("/quiz04/result-bmi3")
	public ModelAndView result_bmi3(@RequestParam Map<String, String> paramMap) {
		
		Double heightDb = Double.parseDouble(paramMap.get("height"));
		Double weightDb = Double.parseDouble(paramMap.get("weight"));
		
		//double bmi = weightDb / (heightDb/100)*(heightDb/100);
		double bmi = weightDb / Math.pow(heightDb/100, 2);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("quiz/quiz04/result-bmi");
		
		mav.addObject("name", paramMap.get("name"));
		mav.addObject("height", paramMap.get("height"));
		mav.addObject("weight", paramMap.get("weight"));
		mav.addObject("bmi", bmi);
		
		return mav;
	}
	
	@RequestMapping("/quiz04/result-bmi4")
	public ModelAndView result_bmi4(@RequestParam Map<String, String> paramMap) {
		
		Double heightDb = Double.parseDouble(paramMap.get("height"));
		Double weightDb = Double.parseDouble(paramMap.get("weight"));
		
		//double bmi = weightDb / (heightDb/100)*(heightDb/100);
		double bmi = weightDb / Math.pow(heightDb/100, 2);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("quiz/quiz04/result-bmi");
		
		PersonBmi personBmi = new PersonBmi();
		personBmi.setName(paramMap.get("name"));
		personBmi.setHeight(paramMap.get("height"));
		personBmi.setWeight(paramMap.get("weight"));
		personBmi.setBmi(bmi);
		
		mav.addObject("personBmi", personBmi);
		
		return mav;
	}
}
