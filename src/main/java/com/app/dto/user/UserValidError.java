package com.app.dto.user;

import lombok.Data;

@Data
public class UserValidError {
	
	//값x, 유효성 검증 결과 에러메시지
	String id;
	String pw;
	String name;
	String userType;
}
