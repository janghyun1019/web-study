package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/quiz/session/login")
    public String loginPage() {
        return "quiz/session/login";
    }

    @PostMapping("/quiz/session/login")
    public String login(@RequestParam String id, @RequestParam String password, HttpSession session) {
        if ("admin".equals(id) && "1234".equals(password)) {
            session.setAttribute("user", id);
            session.setAttribute("count", 0); // 초기 count 설정
            return "redirect:/quiz/session/count";
        }
        return "redirect:/quiz/session/login?error";
    }

    @GetMapping("/quiz/session/count")
    public String countPage(HttpSession session, Model model) {
        String user = (String) session.getAttribute("user");
        Integer count = (Integer) session.getAttribute("count");

        if (user == null) {
            model.addAttribute("user", "로그인된 사용자가 없습니다");
            model.addAttribute("count", 0);
        } else {
            count = (count == null) ? 1 : count + 1;
            session.setAttribute("count", count);
            model.addAttribute("user", user);
            model.addAttribute("count", count);
        }

        return "quiz/session/count"; // count.jsp 페이지 반환
    }

    @GetMapping("/quiz/session/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 기록 삭제 (완전 초기화)
        return "redirect:/quiz/session/count"; // 로그아웃 후 count 페이지로 이동
    }
}
