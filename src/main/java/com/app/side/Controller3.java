package com.app.side;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller3 {
	
	public MyModelAndView  process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//request.getParameter("category");
		
		MyModelAndView mav = new MyModelAndView();
		mav.setViewName("/WEB-INF/views/prac/prac01.jsp");
		
		//mav.setViewName("prac/prac01"); //viewResolver 설정 완료 된 이후
		
		mav.addObject("key", "value");
		mav.addObject("key22", "value22");
		
		return mav;
	}
	
	public MyModelAndView process(Map<String, String> paramMap) throws ServletException, IOException {
		
		//request.getParameter("category");
		//paramMap.get("category");
		
		MyModelAndView mav = new MyModelAndView();
		mav.setViewName("/WEB-INF/views/prac/prac01.jsp");
		
		mav.addObject("key", "value");
		mav.addObject("key22", "value22");
		
		return mav;
	}
}
