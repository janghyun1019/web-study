package com.app.dao.user;

import java.util.List;

import com.app.dto.user.User;

public interface UserDAO {

	int saveUser(User user);
	
	List<User> findUserList();
	
	User findUserById(String id);
	
	public User checkUserLogin(User user);
}
