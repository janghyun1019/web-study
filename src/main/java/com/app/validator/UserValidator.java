package com.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.dto.user.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User)target;
		
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

}
