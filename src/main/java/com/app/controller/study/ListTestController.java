package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/listTest") // 클래스 레벨에서 기본 경로 설정
public class ListTestController {

    @GetMapping("/re/listTest")
    public String handleListTest(HttpServletRequest request) {
        String type = request.getParameter("type");

        if (type == null || type.isEmpty()) {
            // 잘못된 요청: type 파라미터가 없거나 비어있음
            request.setAttribute("error", "type 파라미터가 필요합니다.");
            return "error/invalidRequest";
        }

        switch (type) {
            case "member":
                // Forward 처리 (URL 주소 유지)
                request.setAttribute("type", "member");
                return "forward:/jstl/listTest/member";

            case "str":
                // Redirect 처리 (URL 주소 변경)
                return "redirect:/jstl/listTest/str";

            default:
                // 잘못된 요청 처리
                request.setAttribute("error", "Invalid type parameter");
                return "error/invalidRequest";
        }
    }

    // 글로벌 예외 처리
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView mav = new ModelAndView("error/errorPage");
        mav.addObject("error", ex.getMessage());
        return mav;
    }
}
