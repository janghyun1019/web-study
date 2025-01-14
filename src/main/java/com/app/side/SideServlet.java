package com.app.side;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//WebServlet
public class SideServlet {

	//웹 요청이 왔을때 처리
	protected void service(HttpServletRequest request,
							HttpServletResponse response ) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		MyViewResolver myViewResolver = new MyViewResolver();
		
		if(requestURI.equals("/quiz04/main1-1")) {
			//어떤 컨트롤러를 호출!
			Controller1 con1 = new Controller1();
			con1.process(request, response);
		}
		
		if(requestURI.equals("/quiz04/request1-3")) {
			//어떤 컨트롤러를 호출!
			Controller2 con2 = new Controller2();
			MyView myView = con2.process(request, response);
			myView.render(request, response);
			
		}
		
		if(requestURI.equals("/quiz04/request33")) {
			Controller3 con3 = new Controller3();
			
			//request, response 바로 전달
			//MyModelAndView mav = con3.process(request, response);
			//mav  viewName
			//mav  model  map<String, Object>
			
			
			//request.getParameterMap()  Map<String, String[]>
			//request -> map 옮겨 담기
			Enumeration<String> paramNames = request.getParameterNames();
			Map<String, String> paramMap = new HashMap<String, String>();
			while(paramNames.hasMoreElements()) {
				//key
				String name = paramNames.nextElement(); 
				
				paramMap.put(name, request.getParameter(name));
			}
			
			MyModelAndView mav = con3.process(paramMap);
			
			
			MyView myView = new MyView();			//   prac/prac01
			myView.viewName = myViewResolver.viewResolve(mav.viewName);
			myView.render(request, response, mav.model);
		}
		
		
		if( requestURI.equals("경로비교")) {
			Controller4 con4 = new Controller4();
			MyModel myModel = new MyModel();
			
			String viewName = con4.process(myModel);
			
			// myModel 데이터
			// viewName 화면 이름
			
			MyView myView = new MyView();
			myView.viewName = myViewResolver.viewResolve(viewName);
			myView.render(request, response, myModel.model);
		}
		
		if( requestURI.equals("경로비교22")) {
			Controller4 con4 = new Controller4();
			MyModel myModel = new MyModel();
			
			Enumeration<String> paramNames = request.getParameterNames();
			Map<String, String> paramMap = new HashMap<String, String>();
			while(paramNames.hasMoreElements()) {
				//key
				String name = paramNames.nextElement(); 
				
				paramMap.put(name, request.getParameter(name));
			}
			
			String viewName = con4.process(myModel, paramMap);
			
			// myModel 데이터
			// viewName 화면 이름
			
			MyView myView = new MyView();
			myView.viewName = myViewResolver.viewResolve(viewName);
			myView.render(request, response, myModel.model);
		}
	}
}














