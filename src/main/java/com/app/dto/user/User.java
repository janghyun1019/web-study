package com.app.dto.user;

import lombok.Data;

@Data
public class User {
	
//	public static final String USERTYPE_CUSTOMER = "CUS";
//	public static final String USERTYPE_ADMIN = "ADM";
	
	String id;
	String pw;
	String name;
	String userType;  // CUS(Customer)   ADM(Admin)
	
}
