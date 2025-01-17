package com.app.controller.study;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.Product;
import com.app.dto.study.ProductRequestForm;

@Controller
public class Request03Controller {
	
	@GetMapping("/param1")
	public String param1(HttpServletRequest request) {
		
		//http://localhost:8080/param1?name=abcd&count=123
		System.out.println("/param1");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("count"));
		
		return "requestParam/param1";
	}
	
	@PostMapping("/param2")
	public String param2(HttpServletRequest request) {
		
		//http://localhost:8080/param1?name=abcd&count=123
		System.out.println("/param2");
		System.out.println(request.getParameter("abc"));
		System.out.println(request.getParameter("def"));
		
		return "requestParam/param2";
	}
	
	@RequestMapping("/param3")
	public String param3(HttpServletRequest request) {
		
		System.out.println("/param3");
		System.out.println(request.getParameter("p1"));
		System.out.println(request.getParameter("p2"));
		
		//if(request.getParameter("p2"))
		
		//System.out.println(request.getParameter("p3"));  단일
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
		//System.out.println(p3);
		
		return "requestParam/param2"; 
	}
	
	@RequestMapping("/param6")	//   /param6?p1=sadf
	public String param6(@RequestParam(value ="p1") String param1Value,
						 @RequestParam(required = false, defaultValue = "default") String p2) {
		
		System.out.println("/param6");
		System.out.println(param1Value);
		System.out.println(p2);
		//System.out.println(p3);
		
		return "requestParam/param2"; 
	}
	
	@RequestMapping("/param7/{itemId}")
	public String param7(@PathVariable String itemId) {
		System.out.println("/param7");
		System.out.println(itemId);
		
		return "requestParam/param2"; 
	}
	
	@RequestMapping("/param8")		//		/param8?p1=asdf&p2=safd&p3=asdf
	public String param8(@RequestParam Map<String, String> paramMap) {
		System.out.println("/param8");
		System.out.println(paramMap.get("p1"));
		System.out.println(paramMap.get("p2"));
		System.out.println(paramMap.get("p3"));
		
		//System.out.println(paramMap.get("p4"));
		
		
		return "requestParam/param2";
	}
	
	@GetMapping("/param9")
	public String param9() {
		
		return "requestParam/param9";
	}
	
	@PostMapping("/param9")
	//public String param9Action(@ModelAttribute ProductRequestForm productForm) {
	public String param9Action(@ModelAttribute Product product) {
		
		System.out.println(product.id);
		System.out.println(product.name);
		System.out.println(product.price);
		System.out.println(product.getPrice());
		
		//ProductRequestForm -> Product
		
		return "requestParam/param9after";
	}
	
	
	
}



