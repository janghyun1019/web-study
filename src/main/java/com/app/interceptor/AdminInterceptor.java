package com.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.app.service.user.UserService;
import com.app.util.LoginManager;

public class AdminInterceptor implements HandlerInterceptor {

	@Autowired
	UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(LoginManager.isLogin(request) == false) {
			
			response.sendRedirect("/error/error");
			//경고창("잘못된 접근입니다."); -> main 연결
			return false;
		}
		
		if(LoginManager.isLogin(request)) {
			String userId = LoginManager.getLoginUserId(request);
			User loginUser = userService.findUserById(userId);
			
			System.out.println(loginUser);
			System.out.println(CommonCode.USER_USERTYPE_ADMIN);
			if(loginUser != null)
				System.out.println(loginUser.getUserType().equals(CommonCode.USER_USERTYPE_ADMIN));
			
			if(loginUser == null || loginUser.getUserType().equals(CommonCode.USER_USERTYPE_ADMIN) == false) {
				//response.sendRedirect("/admin/login");
				response.sendRedirect("/error/error");
				//경고창("잘못된 접근입니다."); -> main 연결
				return false;
			}
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
