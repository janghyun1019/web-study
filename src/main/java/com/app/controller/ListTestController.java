package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListTestController {

    @GetMapping("/re/listTest")
    public String handleListTest(HttpServletRequest request) {
        String type = request.getParameter("type");
        
        if ("member".equals(type)) {
            // 1번: Forward 처리 (URL 주소 유지) 잠시만요 연결해드릴게요
            request.setAttribute("type", "member");
            return "forward:/jstl/listTest/member";
        } else if ("str".equals(type)) {
            // 2번: Redirect 처리 (URL 주소 변경) 전화 끈으시구 번호 알려드릴께요 거기로 전화해보세요
            return "redirect:/jstl/listTest/str";
        } else {
            // 잘못된 요청 처리 (옵션)
            request.setAttribute("error", "Invalid type parameter");
            return "error/invalidRequest";
        }
    }
}
