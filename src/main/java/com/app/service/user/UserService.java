package com.app.service.user;

import java.util.List;

import com.app.dto.user.User;
import com.app.dto.user.UserSearchCondition;

public interface UserService {
	
	int saveUser(User user);
	
	int saveCustomerUser(User user);
	int saveAdminUser(User user);
	
	List<User> findUserList();
	
	User checkUserLogin(User user);
	
	User findUserById(String id);
	
	int modifyUser(User user);
	
	List<User> findUserListBySearchCondition(UserSearchCondition userSearchCondition);
	
	/**
	 * 아이디 중복 여부 체크
	 * 
	 * 사용예시) boolean isDup = isDuplicatedId("abc");
	 * 		  if(isDup){...}
	 * 
	 * @param id 중복 여부를 확인하고자 하는 User id
	 * @return 붕복여부 (true:중복, false:사용가능)
	 * @see
	 * 
	 **/
	
	boolean isDuplicatedId(String id);
	
	
}
