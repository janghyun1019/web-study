package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RestQuizController {

	@GetMapping("/rest/quiz1")
	public String quiz1() {
		return "quiz/rest/quiz1";
	}
	
	@ResponseBody
	@GetMapping("/rest/quiz2")
	public String quiz2() {
		return "return text quiz2";
	}
	
	@ResponseBody
	@GetMapping("/rest/quiz3")
	public User quiz3() {
		User user = new User();
		user.setId("quizid");
		user.setPw("secret");
		user.setName("namequiz");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		return user;
		/*
		User user = new User();
		user.setId("quizid");
		user.setPw("secret");
		user.setName("namequiz");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println(jsonStr);
		//jackson라이브러리 활용 
		//객체 -> json포맷 String 변환 -> 리턴
		return jsonStr;  //json 포맷 텍스트 리턴
		*/
	}
	
}
