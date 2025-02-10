package com.app.validator;

import org.springframework.validation.Errors;

import com.app.dto.user.User;
import com.app.dto.user.UserValidError;

public class UserCustomValidator {
	
	
	public static boolean validate(User user, UserValidError userVaildError) {
		boolean result = true;
		
		if(user.getId() == null || user.getId().equals("")
				|| user.getId().trim().length() == 0 ) {
			userVaildError.setId("id 입력 안하셨어요");
			result = false;
		}
		
		if(user.getId().equals("admin")) {
			userVaildError.setId("사용 불가한 아이디입니다.");
			result = false;
		}
		
		if(user.getPw().length() < 8 || user.getPw().length() > 12) {
			userVaildError.setPw("8~12자리로 입력!!해!주세요~!~!!");
			result = false;
		}
		
		return result;
	}
	
	

	public static void validate(User user, Errors errors) {
		
		if(user.getId() == null || user.getId().equals("")
				|| user.getId().trim().length() == 0 ) {
			errors.rejectValue("id", "UserIdEmpty", "id 입력 안하셨어요");
		}
		
		if(user.getId().equals("admin")) {
			errors.rejectValue("id", "UserIdEmpty", "사용 불가한 아이디입니다.");
		}
		
		if(user.getPw().length() < 8 || user.getPw().length() > 12) {
			errors.rejectValue("pw", "UserPwSize", "8~12자리로 입력!!해!주세요!");
		}
		
	}
	
	
	
	
	public static void validateLoginUser(User user) {
	}
	
	public static void validateAdminUser(User user) {
		
	}
}
