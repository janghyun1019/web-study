package com.app.controller.study;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Rest2Controller {

	@GetMapping("/rest/rest4")
	public String rest4() {
		return "rest/rest4";
	}
	
	@GetMapping("/rest/rest5")
	public String rest5() {
		return "rest5 return text restController";
		//단순 텍스트
	}
	
	@GetMapping("/rest/rest6")
	public String rest6() {
		
		// json 포맷
		
		/*
		단순 텍스트
		abc,qwe,name1,CUS 
		return "abc,qwe,name1,CUS";
		
		많은 데이터 전달 -> 표현 규칙 -> JSON
		{
			"id":"abc",
			"pw":"qwe",
			"name":"name1",
			"userType":"CUS"
		}
		 */
		
		/*
		JSON 포맷으로 return 을 하려면?
		1) 직접 포맷대로 수동으로 작성
		 
		
		return "{"
				+ "	\"id\":\"abc\","
				+ "	\"pw\":\"qwe\","
				+ "	\"name\":\"name1\","
				+ "	\"userType\":\"CUS\""
				+ "	}";
		*/
		
		/*
	    2) json 활용을 도와주는 라이브러리 사용
	    	1. json-simple
		 
		
		JSONObject obj = new JSONObject();
		obj.put("id", "abc");
		obj.put("pw", "qwe");
		obj.put("name", "name1");
		obj.put("userType", "CUS");
		
		System.out.println(obj.toJSONString());
		
		return obj.toJSONString();
		*/
			
		/*
			2. jackson 라이브러리 
		 */
		
		User user = new User();
		user.setId("abc");
		user.setPw("qwe");
		user.setName("name11");
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
		return jsonStr;
	}
	
	@GetMapping("/rest/rest7") //사전 조건 : jackson 라이브러리 존재
	public User rest7() { //객체 리턴 -> json 포맷 변환  
		//User 객체 리턴!
		User user = new User();
		user.setId("abc2");
		user.setPw("qwe2");
		user.setName("name1122");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		return user;
	}
	
}
