package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Rest1Controller {

	@GetMapping("/rest/rest1")
	public String rest1() {
		return "rest/rest1";  //이 경로에 있는 view 를 반환!
	}
	
	@ResponseBody
	@GetMapping("/rest/rest2")
	public String rest2() {
		return "rest/rest2";
		//return 안에 있는 단순 text 만 전달
	}
	
	@ResponseBody
	@GetMapping("/rest/rest3")
	public String rest3() {
		return "this is response body. just text";
		//return 안에 있는 단순 text 만 전달
	}
	
	
}
