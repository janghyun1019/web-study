package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class Request01Controller {
	
	// 요청 주소별로 맵핑
	
	@RequestMapping("/url1")  // 요청을 했을때 담당하는 것
	public String url1() {
		// 메소드 이름이 겹치지만 않으면 아무거나 가능하다
		// 이름을 맞춰주는게 좋다
		// 괄호안에 명시된 주소로 요청이 왔을대 실행
		
		return "url1"; // 그 이름을 가지고 있는 view 파일을 명시
		
		//  /WEB-INE/views/
	}
	
	@RequestMapping("/url2")
	public String url2() {
		return "home";
	}

	@RequestMapping("/url3")
	public String url3() {
		return "url1";
	}
	
	@RequestMapping("/url4")  //  GET POST 둘다 수신
	public String url4() {
		return "url/url4";
	//  /WEB-INE/views/     .jsp
	//					url1
	//  /WEB-INE/views/url/url4.jsp	
	//					   url/url4.jsp		
		
	}
	
	// HTTP 통신 Method = GET / POST / DELETE / PUT / PATCH
	// 우리는 GET / POST 만 구분하면 된다
	// GET으로 보내면 GET으로만 받고 POST로 보내면 POST방식으로만 받아야 한다
	@RequestMapping(value = "/url5", method = RequestMethod.GET)
	public String url5() {
		return "url/url4";
	}
	
	@RequestMapping(value = "/url6", method = RequestMethod.POST) // POST 요청만 받는다
	public String url6() {
		return "url/url4";
	}
	
	@RequestMapping("/ur7")
	public String url7() {
		return "url/url4";
	}

	@RequestMapping("/ur8")
	public String url8() {
		return "url/url4";
	}	

}
