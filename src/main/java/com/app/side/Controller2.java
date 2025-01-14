package com.app.side;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller2 {
	public MyView  process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//Controller2 자체 처리 로직
		MyView myView = new MyView();
		myView.viewName = "/WEB-INF/views/home.jsp";
		
		return myView;
	}
}
