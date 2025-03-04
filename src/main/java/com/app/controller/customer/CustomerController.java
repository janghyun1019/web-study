package com.app.controller.customer;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.controller.admin.AdminController;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.file.FileInfo;
import com.app.dto.user.ProfileRequestForm;
import com.app.dto.user.User;
import com.app.dto.user.UserDupCheck;
import com.app.dto.user.UserProfileImage;
import com.app.dto.user.UserValidError;
import com.app.service.file.FileService;
import com.app.service.user.UserService;
import com.app.util.FileManager;
import com.app.util.LoginManager;
import com.app.util.SHA256Encryptor;
import com.app.validator.UserCustomValidator;
import com.app.validator.UserValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	FileService fileService;
	
	
	//회원가입
	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}
	
	@PostMapping("/customer/signup")
	public String signupAction(/*@Valid*/ @ModelAttribute User user, BindingResult br, Model model) {
		
		
		//별도로 생성한 UserValidError 객체 사용하는 케이스
		UserValidError userVaildError = new UserValidError();
		boolean validResult = UserCustomValidator.validate(user, userVaildError);
		
		if(validResult == false) { //뭔가 걸렸다
			//유효성 검증 통과 실패
			//저장 진행하지 말고 다시 가입페이지로 이동
			model.addAttribute("userVaildError", userVaildError);
			
			return "customer/signup";	
		}
		
		
		/*  
		//BindingResult (Errors) 사용하는 케이스
		//유효성검증!
		UserCustomValidator.validate(user, br);
		
		//유효성 검증 성공 여부
		if(br.hasErrors()) {
			List<ObjectError> errorList =  br.getAllErrors();				
			for(ObjectError er : errorList) {				
				System.out.println(er.getObjectName());			
				System.out.println(er.getDefaultMessage());			
				System.out.println(er.getCode());			
				System.out.println(er.getCodes()[0]);			
			}				

			return "customer/signup";		
		}
		*/
		
		//client -> request -> userRequestForm
		// userRequestForm -> user 변환
		//saveUser(user객체);
		
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER );
		String encPw;
		try {
			//사용자 비밀번호 암호화 처리
			encPw = SHA256Encryptor.encrypt(user.getPw());
			user.setPw(encPw);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			//잘못됐다 안내 -> 페이지 전환
		}
		
		int result = userService.saveUser(user); //DB 에 user정보 저장 (가입)
		
		System.out.println("회원가입 처리 결과 : " + result);
		
		if(result > 0) {
			return "redirect:/main";
		} else {
			return "customer/signup";			
		}
	}
	
	
	/*
	@InitBinder("user")						
	public void initUserBinder(WebDataBinder binder) {								
		UserValidator validator = new UserValidator();								
		//binder.setValidator(validator);								
		binder.addValidators(validator);								
	}
	*/								

	
	
	@ResponseBody
	@RequestMapping("/customer/checkDupId")
	public String checkDupId(@RequestBody String data) {
		
		//...
		System.out.println("/customer/checkDupId 요청 들어옴");
		System.out.println(data);
		
		log.info("{} id 중복체크 시도함", data);
		
		//매개변수 data : 중복여부를 확인하고 싶은 아이디
		
		//id 중복 여부 체크 -> 결과 return
		boolean result = userService.isDuplicatedId(data); //비교할 id
		
		if(result) {
			return "Y";  //중복O -> Y
		} else {
			return "N";  //중복X -> N
		}
		
		//return "okay dupcheckid";
	}
	
	
	@ResponseBody
	@RequestMapping("/customer/checkDupIdJson")
	public ApiResponse<String> checkDupIdJson(@RequestBody UserDupCheck userDupCheck) {
								//id :''   type:''
								//JSON Format Text -> UserDupCheck 객체형태로 파싱
		
		//...
		System.out.println("/customer/checkDupId 요청 들어옴");
		System.out.println(userDupCheck);  //data : JSON Format Text -> parse (json-simple, Jackson)
		
		//매개변수 data : 중복여부를 확인하고 싶은 아이디
		
		//id 중복 여부 체크 -> 결과 return
		boolean result = userService.isDuplicatedId(userDupCheck.getId()); //비교할 id
		
		ApiResponse<String> apiResponse = new ApiResponse<String>();
		ApiResponseHeader header = new ApiResponseHeader();
		header.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		header.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);
		
		apiResponse.setHeader(header);
		
		
		if(result) {
			apiResponse.setBody("Y");  //중복O -> Y
		} else {
			apiResponse.setBody("N");  //중복X -> N
		}
		
		return apiResponse;
	}
	
	
	@GetMapping("/customer/login")
	public String login() {
		return "customer/login";
	}
	
	@PostMapping("/customer/login")
	public String loginAction(User user, HttpSession session) {
		
		//user   id pw 화면으로부터 전달
		// name userType : null
		
		//user 로그인 할 수 있게 정보가 들어있는지! 확인!
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER );
		
		try {
			user.setPw(SHA256Encryptor.encrypt(user.getPw()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User loginUser = userService.checkUserLogin(user);
		
		if(loginUser == null) { // 아이디X? 아이디O&비번X  null
			return "customer/login";
		} else {  // 아이디&비번이 맞으면 loginUser 
			//로그인 정보가 맞아서 로그인 성공
			//session.setAttribute("loginUser", loginUser);
			//session.setAttribute("loginUserId", loginUser.getId());
			
			//로그인 성공시 세션에 로그인 ID 저장
			LoginManager.setSessionLogin(session, loginUser.getId());
			
			log.info( loginUser.getId() + "사용자 로그인함");
			
			return "redirect:/main";
		}
	}
	
	@GetMapping("/customer/logout")
	public String logout(HttpSession session) {
		LoginManager.logout(session);
		//session.invalidate();
		
		return "redirect:/main";
	}
	
	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {
		
		//session 에 loginUserId 값이 존재유무
		//if(session.getAttribute("loginUserId") != null) { //로그인 상태
		if(LoginManager.isLogin(session)) {
			
			//로그인되어있는 사용자의 정보를 보여주기
			//User user = userService.findUserById( (String)session.getAttribute("loginUserId") );
			User user = userService.findUserById( LoginManager.getLoginUserId(session) );
			model.addAttribute("user", user);
			
			 //userid -> UserProfileImage -> (fileName) -> FileInfo
			
			UserProfileImage upi = userService.findUserProfileImageById(user.getId());
			
			if(upi != null) {
				FileInfo fileInfo = fileService.findFileInfoByFileName(upi.getFileName());
				model.addAttribute("fileInfo", fileInfo);
			}
			
			return "customer/mypage";
		}
		//로그인 안된 상태
		return "redirect:/customer/login";
		
		
		
	}
	
	
	/*
	@PostMapping("/customer/profile")
	public String profileAction(HttpServletRequest request,
			MultipartRequest multipartRequest) {
		
		System.out.println( request.getParameter("id") );
		System.out.println( request.getParameter("name") );
		
		MultipartFile file = multipartRequest.getFile("profileImage");
		
		System.out.println( file.getName()  );
		System.out.println( file.getOriginalFilename()  );
		System.out.println( file.isEmpty()  );
		System.out.println( file.getContentType() );
		System.out.println( file.getSize()  );
		
		return "redirect:/customer/mypage";
	}
	*/
	
	@PostMapping("/customer/profile")
	public String profileAction(ProfileRequestForm profileRequestForm) {
		
		System.out.println( profileRequestForm.getId() );
		System.out.println( profileRequestForm.getName() );
		
		MultipartFile file = profileRequestForm.getProfileImage();
		//첨부파일 수신
		
		//정보 확인
		System.out.println( file.getName()  );
		System.out.println( file.getOriginalFilename()  );
		System.out.println( file.isEmpty()  );
		System.out.println( file.getContentType() );
		System.out.println( file.getSize()  );
		
		//1. 실제 파일을 폴더에 저장
		
		/*
		//자체 저장
		try {
			file.transferTo( new File("d:/fileStorage/" + file.getOriginalFilename() )  );
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		//FileManager 활용
		
		try {
			
			FileInfo fileInfo = FileManager.storeFile(file);
			//실제 폴더에 파일을 저장
		
			//2. 파일 정보를 DB에 저장
			int result = fileService.saveFileInfo(fileInfo);
			//파일 정보만 DB에 저장
			
			if(result > 0) {
				log.info(fileInfo.getFileName() + " 파일 저장 잘됨");
				
				//UserProfileImage 에도 연결할수 있게 저장
				//저장된 파일이 어떤 유저의 프로필 이미지다! 연결 정보 저장!
				
				UserProfileImage upi = new UserProfileImage();
				//userid를 어디서 가져오나?
				//1) 세션 
				//2) view 에 hidden 으로 저장된 id를 같이 전송 
				upi.setId(profileRequestForm.getId());	//사용자id
				upi.setFileName(fileInfo.getFileName()); //파일name
				
				int result2 = userService.saveUserProfileImage(upi);
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/customer/mypage";
	}
}





