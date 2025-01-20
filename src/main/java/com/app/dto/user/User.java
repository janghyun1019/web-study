package com.app.dto.user;

import lombok.Data;

@Data
public class User {

	String id;
	String pw;
	String name;
	String userType;  // CUS(Customer)   ADM(Admin)
	
}
