package com.app.dto.user;

import lombok.Data;

@Data
public class UserSearchCondition {
	
	String searchKeyword;
	String id;
	String name;
	String userType;
}
