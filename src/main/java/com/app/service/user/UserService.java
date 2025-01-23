package com.app.service.user;

import java.util.List;

import com.app.dto.user.User;

public interface UserService {
	
	int saveUser(User user);
	
	int saveCustomerUser(User user);
	int saveAdminUser(User user);
	
	List<User> findUserList();
	
	User checkUserLogin(User user);
	
	User findUserById(String id);
	
	int modifyUser(User user);
}
