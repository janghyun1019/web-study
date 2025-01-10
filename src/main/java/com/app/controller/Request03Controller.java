package com.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.Product;
import com.app.dto.ProductRequestForm;

@Controller
public class Request03Controller {
	
	@GetMapping("/param1")
	public String parmet1(HttpServletRequest request) {
		
		System.out.println("/param1");
		
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("count"));
		
		return "requestParam/param1";
	}
	
	@PostMapping("/param2")
	public String parmet2(HttpServletRequest request) {
		
		System.out.println("/param2");
		
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("count"));
		
		return "requestParam/param2";
	}
	
	@RequestMapping("/param3")
	public String param3(HttpServletRequest request) {
		
		System.out.println("/param3");
		System.out.println(request.getParameter("p1"));
		System.out.println(request.getParameter("p2"));
		System.out.println(request.getParameter("p3"));
		
		//System.out.println(request.getParameter("p3"));
		String[] p3Values = request.getParameterValues("p3");
		for(String p3 : p3Values) {
			System.out.println(p3);
		}		
		
		return "requestParam/param2";
		
	}
	
	@RequestMapping("/param4")
	public String param4(@RequestParam String p1, @RequestParam String p2) {
		
		System.out.println("/param4");
		System.out.println(p1);
		System.out.println(p2);
		
		return "requestParam/param2";
		
	}
	
	@RequestMapping("/param5")
	public String param5(@RequestParam String p1, @RequestParam(required = false) String p2) {
		
		System.out.println("/param5");
		System.out.println(p1);
		System.out.println(p2);
		// System.out.println(p3);
		
		return "requestParam/param2";
		
	}
	
	@RequestMapping("/param6")		// /param6?p1=sadf
	public String param6(@RequestParam(value = "p1") String p1,
						 @RequestParam(required = false, defaultValue = " default") String p2) {
														// 파라미터 값이 들어오지 않으면 디폴트벨류로 시작하겠다
		System.out.println("/param6");
		System.out.println(p1);
		System.out.println(p2);
		// System.out.println(p3);
		
		return "requestParam/param2";
		
	}
	
	@RequestMapping("/param7/{itemId}")  // /(슬러시)단위로 경로가 다르다 슬러시까지의 경로가 어디를 나타낸다
	public String param7(@PathVariable String itemId) { // 경로상의 아이디를 넣어준다
		
		System.out.println("/param7");
		System.out.println(itemId);
		
		return "requestParam/param2";
	}
	
	@RequestMapping("/param8/{itemId}")  // 맵형태로 선언을 해둔다  /param8?p1=asdf&p2=safd&p3=adsdf
	public String param8(@RequestParam Map<String, String> paramMap) { 
		
		System.out.println("/param8");
		System.out.println(paramMap.get("p1"));
		System.out.println(paramMap.get("p2"));
		System.out.println(paramMap.get("p3"));
		
//		System.out.println(paramMap.get("p4"));  몇개는 들어올 수 있다 없어도 null로 나온다
		
		return "requestParam/param2";
	}
	
	@GetMapping("/param9")
	public String param9() {
		
		return "requestParam/param9";
		
	}
	
	@PostMapping("/param9")  //후속처리
	public String param9Action(@ModelAttribute ProductRequestForm productForm) {
		
		System.out.println(productForm.id);
		System.out.println(productForm.name);
		System.out.println(productForm.price);
		System.out.println(productForm.getPrice());
		
		
		return "requestParam/param9after";
		
	}
	
	
}











