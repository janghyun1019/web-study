package com.app.controller.study;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.study.api.ApiDelivery;
import com.app.dto.study.api.ApiMenu;
import com.app.dto.study.api.ApiResponseDelivery;
import com.app.dto.study.api.ApiStore;
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
		user.setName("name이름1122");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);

		return user;
	}

	@GetMapping("/rest/rest8")
	public ApiMenu rest8() {
		ApiMenu am1 = new ApiMenu();
		am1.setName("식혜");
		am1.setPrice(3000);

		return am1;
	}

	@GetMapping("/rest/rest9")
	public List<ApiMenu> rest9() {

		List<ApiMenu> menuList = new ArrayList<ApiMenu>();

		ApiMenu am1 = new ApiMenu();
		am1.setName("식혜");
		am1.setPrice(3000);

		menuList.add(am1);
		menuList.add(new ApiMenu("아이스티", 2500));
		menuList.add(new ApiMenu("아메리카노", 2000));
		menuList.add(new ApiMenu("카페라떼", 3500));

		return menuList;
	}

	@GetMapping("/rest/rest10")
	public ApiDelivery rest10() {
		ApiDelivery apiDelivery = new ApiDelivery();

		apiDelivery.setStaffName("나배달");
		apiDelivery.setDestination("로하스 7층");
		apiDelivery.setPhone("010-1234-1233");

		ApiStore apiStore = new ApiStore();
		apiStore.setName("롯데리아");
		apiStore.setAddress("대홍동 399-5번지 1층");
		apiStore.setTel("02-112-3344");

		apiDelivery.setApiStore(apiStore);

		List<ApiMenu> menuList = new ArrayList<ApiMenu>();
		menuList.add(new ApiMenu("치즈버거", 3000));
		menuList.add(new ApiMenu("라이스버거", 4000));
		menuList.add(new ApiMenu("불고기버거", 3500));

		apiDelivery.setMenuList(menuList);

		return apiDelivery;
	}

	@GetMapping("/rest/rest11")
	public int rest11() {
		//10 정상
		//20 일시적인 문제
		//30 인증불가
		//40 데이터 없음
		return 10;
	}

	@GetMapping("/rest/rest12")
	public ApiResponseHeader rest12() {
		//10 정상
		//20 일시적인 문제
		//30 인증불가
		//40 데이터 없음
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader();
		//		apiResponseHeader.setResultCode("10");
		//		apiResponseHeader.setResultMessage("정상");
		apiResponseHeader.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);

		return apiResponseHeader;
	}

	@GetMapping("/rest/rest13")
	public ApiResponseDelivery rest13() {

		//header
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader();
		apiResponseHeader.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);

		//body
		ApiDelivery apiDelivery = new ApiDelivery();

		apiDelivery.setStaffName("나배달");
		apiDelivery.setDestination("로하스 7층");
		apiDelivery.setPhone("010-1234-1233");

		ApiStore apiStore = new ApiStore();
		apiStore.setName("롯데리아");
		apiStore.setAddress("대홍동 399-5번지 1층");
		apiStore.setTel("02-112-3344");

		apiDelivery.setApiStore(apiStore);

		List<ApiMenu> menuList = new ArrayList<ApiMenu>();
		menuList.add(new ApiMenu("치즈버거", 3000));
		menuList.add(new ApiMenu("라이스버거", 4000));
		menuList.add(new ApiMenu("불고기버거", 3500));

		apiDelivery.setMenuList(menuList);

		ApiResponseDelivery res = new ApiResponseDelivery();
		res.setHeader(apiResponseHeader);
		res.setBody(apiDelivery);

		return res;
	}

	@GetMapping("/rest/rest14")
	public ApiResponse<User> rest14() {
		List<String> strList;
		List<User> userList;
		List<ApiMenu> menuList2;

		ApiResponse<String> ar1;
		ApiResponse<ApiMenu> ar2;
		ApiResponse<ApiDelivery> ar3;

		ApiResponse<User> res = new ApiResponse<User>();

		//header
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader();
		apiResponseHeader.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);

		res.setHeader(apiResponseHeader);
		
		//body
		User user = new User();
		user.setId("idid");
		user.setName("sdname");
		user.setPw("03sadfj");
		user.setUserType(CommonCode.USER_USERTYPE_ADMIN);
		
		res.setBody(user);
		
		return res;
	}

}










