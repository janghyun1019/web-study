package com.app.side;

public class MyViewResolver {
	
	String prefix;
	String suffix;
	
	public MyViewResolver() {
		prefix = "/WEB-INF/views/";
		suffix = ".jsp";
	}

	public String viewResolve(String viewName) {
		//main
		
		//  /WEB-INF/views/prac/prac01.jsp
		
		return prefix + viewName + suffix;
	}
}
