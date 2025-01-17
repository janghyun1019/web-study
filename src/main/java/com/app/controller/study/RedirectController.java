package com.app.controller.study;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dto.study.Member;

@Controller
public class RedirectController {

	@GetMapping("/re/re1")
	public String re1() {
		
		return "re/re1";
	}
	
	@GetMapping("/re/re2")
	public String re2(HttpServletRequest request) {
		System.out.println(request.getParameter("msg"));
		
		//로직
		//request.setAttribute("msg", "re2 직접넣은 msg");
		
		return "re/re2";
	}
	
	@GetMapping("/re/re3")
	public String re3(HttpServletRequest request) {
		
		System.out.println(request.getParameter("msg"));
		
		return "re/re2";		//요청 re3 -> view re2
//		return "re/re3";		//요청 re3 -> view re3 (redirect)
	}
	
	@GetMapping("/re/re4")
	public String re4(HttpServletRequest request, RedirectAttributes ra) {
		//return "re/re2";  //view 경로     ..../re2.jsp
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", "re4 redirect msg");//redirect시 안넘어감
		ra.addAttribute("msg", "re4 ra msg"); //파라미터 넘기기 
		
		//return "redirect:/re/re2"; //그 경로로 다시 요청! 요청할 주소!
		//return "redirect:/re/re2?msg=re4 redirect msg"; //경로에 파라미터 추가
		return "redirect:/re/re2";
		
		//return "/WEB-INF/views/re/re2.jsp";
		//return "redirect:/re/re2";
	}
	
	@GetMapping("/re/re5")
	public String re5(HttpServletRequest request) {
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", "re5 forward msg");
		
		return "forward:/re/re2";
	}
	
	
	//연습
	@GetMapping("/re/listTest")
	public String listTest(@RequestParam String type) {
		
		if(type.equals("str")) {
			return "redirect:/jstl/listTest/str";
		} else {  //memeber
			return "forward:/jstl/listTest/member";
			/*
			List<Member> memberList = new ArrayList<Member>();

			for(int i=1; i<=5; i++) {
				memberList.add(new Member("아이디"+i, "비번"+i, "이름"+i));
			}

			model.addAttribute("memberList", memberList);

			return "jstl/member";
			*/
		}
	}
	
}
