package com.app.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.user.UserDAO;
import com.app.dto.user.User;
import com.app.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public int saveUser(User user) {

		int result = userDAO.saveUser(user);

		return result;
	}
	
	@Override
	public User findLoginUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int saveCustomerUser(User user) {
		//사용자 추가 전 검증 로직
		user.setUserType("CUS");
		int result = userDAO.saveUser(user);
		return result;
	}

	@Override
	public int saveAdminUser(User user) {
		//관리자 추가 전 검증 로직
		user.setUserType("ADM");
		int result = userDAO.saveUser(user);
		return result;
	}


	@Override
	public List<User> findUserList() {
		
		List<User> userList = userDAO.findUserList();
		
		return userList;
	}
	
	@Override
	public User checkUserLogin(User user) { // 로그인   관리자/사용자
		/*
		// 1.서비스자체에서 로직을 수행하는 방법
		User loginUser = userDAO.findUserById(user.getId());
		
		if(loginUser != null && user.getPw().equals(loginUser.getPw())
					&& loginUser.getUserType().equals(user.getUserType()) ) {  // 비밀번호 맞아
				
			return loginUser;			
		} 
		
		return null;
		
		// 아이디&비번이 맞으면 loginUser
		// 아이디X? 아이디O&비번X null
		
		// int 코드 리턴 -> 1:로그인 성공 2:아이디는 맞는데 비번이 틀렸다 3:아이디도 없다 4:휴먼계정
		*/
		
		
		/*
		User loginUser = userDAO.findUserById(user.getId());
		if(loginUser == null) { 
			// 해당 id에 맞는 계정이 없다!
			return null;			
		} else {
			// 해당 id 계정이 있다
			if(user.getPw().equals(loginUser.getPw())) {
				// 비밀번호 맞다!
				 return loginUser;
			}
 		}
		*/
		
		// 2.DAO -> Mapper 쿼리를 만들어서 비교하는 방법
		User loginUser = userDAO.checkUserLogin(user);
		return loginUser; // 값 O 로그인 정보 O
		
		// null 로그인 정보 X
	
	
	}
	
	@Override
	public User findUserById(String id) {
		
		User user = userDAO.findUserById(id);
		
		return user;
		
	}

	@Override
	public User findUserById(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
