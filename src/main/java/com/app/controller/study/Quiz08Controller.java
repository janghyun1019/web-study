package com.app.controller.study;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Quiz08Controller {

	@GetMapping("/quiz/session/login")
	public String login() {
		
		
		return "quiz/quiz08/login"; 
	}
	
	@PostMapping("/quiz/session/login")
	public String loginAction(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//id pw <-> 데이터 비교 -> 정상인지 체크
		HttpSession session = request.getSession();
		
		//로그인 성공 이라고 간주!
		//session.setAttribute("isLogin", true);
		session.setAttribute("loginId", id); //A B
		session.setAttribute("count", 0);
		
		// 로그인 후 -> 내가 쓴 게시글
		// DB조회
		return "redirect:/quiz/session/count";
		
	}
	
	@GetMapping("/quiz/session/count")
	public String count(HttpSession session, Model model) {
		
		//로그인 한 상태면? count 증가
		if(session.getAttribute("loginId") != null) {
			//count 값 증가
			session.setAttribute("count", ((Integer)session.getAttribute("count")) + 1 );
		} else {
			model.addAttribute("count", 0);
		}
		//로그인 안한 상태면? 접속한사용자없다~ count 0 ~ 
		
		return "quiz/quiz08/count";
	}
	
	@GetMapping("/quiz/session/logout")
	public String logout(HttpSession session) {
		//세션에 저장된 정보 삭제
		//session.removeAttribute("loginId");
		//session.removeAttribute("1ount");
		
		//초기화
		session.invalidate();
		
		return "redirect:/quiz/session/count";
	}
}
