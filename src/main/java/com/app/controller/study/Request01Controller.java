package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Request01Controller {
	
	//요청 주소별로 맵핑
	@RequestMapping("/url1")  //괄호안에 명시된 주소로 요청이 왔을때 실행
	public String url1() {
		
		return "url1";   //그 이름을 가지고 있는 view 파일을 명시
		//    /WEB-INF/views/   return한view이름   .jsp
	}
	
	@RequestMapping("/url2")
	public String url2() {
		return "home";
	}
	
	@RequestMapping("/url3")
	public String url3() {
		return "url1";
	}
	
	@RequestMapping("/url4")	// GET POST 둘다 수신
	public String url4() {
		
		return "url/url4";
		//         /WEB-INF/views/            .jsp
		//							 url1
		//         /WEB-INF/views/url/url4.jsp
		//							url/url4
	}
	
	//HTTP 통신 Method = GET / POST / DELETE / PUT / PATCH
	@RequestMapping(value = "/url5", method = RequestMethod.GET)
	public String url5() {
		return "url/url4";
	}
	
	@RequestMapping(value = "/url6", method = RequestMethod.POST)
	public String url6() {
		return "url/url4";
	}
	
	@GetMapping("/url7")
	public String url7() {
		return "url/url4";
	}
	
	@PostMapping("/url8")
	public String url8() {
		return "url/url4";
	}
	
	
}
