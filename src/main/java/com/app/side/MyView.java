package com.app.side;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyView {
	
	public String viewName;
	
	public void render(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
	}
	
	public void render(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model) throws ServletException, IOException {
		
		//model 데이터 -> request 옮겨 담기
		for(String key : model.keySet()) {
			//key : key  value : model.get(key)
			
			request.setAttribute(key, model.get(key));
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
		
	}
	
	
}
