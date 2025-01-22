package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.app.service.user.UserService;

@Controller
public class CustomerController {
	
	@Autowired
	UserService userService;
	
	// 회원가입
	@GetMapping("/customer/signup")
	public String singup() {
		return "customer/signup";
	}
	
	@PostMapping("/customer/signup")
	public String singupAction(User user) {
		
		user.setUserType("CUS");
		int result = userService.saveUser(user);
		
		System.out.println("회원가입 처리 결과 : " + result);
		
		if(result > 0) {
			return "redirect:/main";
		} else {
			return "customer/signup";			
		}

		
	}
	
	@GetMapping("/customer/login")
	public String login() {
		return "customer/login";
	}
	
	@PostMapping("/customer/login")
	public String loginAction(User user, HttpSession session) {
		
		// user  id pw 화면으로 부터 전달
		// name userType : null
		
		// user 객체를 가지고 로그인 할 수 잇게 정보가 들어있는지! 확인!
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER );
		User loginUser = userService.checkUserLogin(user);
		
		if(loginUser == null) { // 아이디X? 아이디O&비번X null
			return "customer/login";
		} else { // 아이디&비번이 맞으면 loginUser
			// 로그인 정보가 맞아서 로그인 성공
			// session.setAttribute("loginUser", loginUser);
			session.setAttribute("loginUserId", loginUser.getId());
			
			return "redirect:/main";
		}		
	}
	
	@GetMapping("/customer/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/main";
	}
	
	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {
		
		// session 에 loginUserId 값이 존재 유무
		if(session.getAttribute("loginUserId") != null) { // 로그인 상태
			
			// 로그인 되어 있는 사용자 
			User user = userService.findUserById( (String)session.getAttribute("loginUserId") );
			model.addAttribute("user", user);
			
			return "customer/mapage";
			
		}
		// 로그인 안된 상태
		return "redirect:/customer/login";
	}
}



