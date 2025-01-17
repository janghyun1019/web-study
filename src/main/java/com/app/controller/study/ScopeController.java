package com.app.controller.study;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScopeController {

	@GetMapping("/scope1")
	public String scope1(Model model) {

		model.addAttribute("requestMsg", "request scope 메시지");
		
		//model -> request setAttribute
		
		return "scope/scope1";
	}
	
	@GetMapping("/scope2")
	public String scope2(HttpServletRequest request) {
		
		request.setAttribute("requestMsg", "request scope 메시지");
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionMsg", "session scope 메시지");
		
		ServletContext app = request.getServletContext();
		app.setAttribute("applicationMsg", "application scope 메시지");
		
		//app.removeAttribute(null)
		
		return "scope/scope2";
	}
	
	@GetMapping("/scope3")
	public String scope3() {
		
		return "scope/scope3";
	}
	
	@GetMapping("/scope4")			//jsessionid sessionStorage
	public String scope4(HttpSession session) {
		
		session.setAttribute("sessionMsg", "/scope4 session scope 메시지");
		
		session.removeAttribute("sessionMsg");  //개별적으로 session 영역에 속성(변수) 지우기
		
		session.invalidate(); // session 영역에 저장된 모든 속성 삭제 ( 세션 초기화 )
		
		return "scope/scope3";
	}
	
}
