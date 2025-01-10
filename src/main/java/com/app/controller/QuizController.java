package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller  // annotation 어노테이션
public class QuizController {

    // 기존 코드 유지
    @GetMapping("/quiz/main")  // 주소창에 보여지는 경로
    public String main() {
        return "/quiz/main";  // 요청경로
    }

    @GetMapping("/quiz/product/mouse")
    public String mouse() {
        return "/quiz/product/mouse";
    }

    @GetMapping("/quiz/product/keyboard")
    public String keyboard() {
        return "/quiz/product/keyboard";
    }
    
    
    

    // 새롭게 추가된 요청 처리 메서드
    // 1. /quiz/req1 - GET 요청
    @GetMapping("/quiz/req1")
    public String req1Get() {
        System.out.println("/quiz/req1 GET 요청");
        
        return "/quiz/main";
    }

    // 2. /quiz/req1 - POST 요청
    @PostMapping("/quiz/req1")
    public String req1Post() {
        System.out.println("/quiz/req1 POST 요청");
        
        return "/quiz/main";
    }
    
    

//    // 3. /quiz/req2 요청 처리 (GET/POST 모두 허용)
//    @RequestMapping("/quiz/req2")
//    public void Req2(HttpServletRequest request,
//                     @RequestParam(required = false) String data1,
//                     @RequestParam(required = false) String data2) {
//        System.out.println("/quiz/req2 요청");
//        System.out.println("data1: " + data1);
//        System.out.println("data2: " + data2);
//    }
    
    public String req2(HttpServletRequest request) {
    	System.out.println(request.getParameter("data1"));
    	System.out.println(request.getParameter("data2"));
    	
    	request.setAttribute("data1", request.getParameter("data1"));
    	request.setAttribute("data1", request.getParameter("data2"));
    	
    	return "/quiz/main";
    }
    
    
}






