package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz03")
public class Quiz3Controller {
    @GetMapping("/pathA")
    public String showQuizPageA(Model model) {
        model.addAttribute("title", "퀴즈 페이지 A");
        model.addAttribute("info", "A 상품정보: 최신 스마트폰");
        return "quiz/quiz03/pathA";
    }

    @GetMapping("/pathB")
    public String showQuizPageB(Model model) {
        model.addAttribute("title", "퀴즈 페이지 B");
        model.addAttribute("info", "B 상품정보: 고급 노트북");
        return "quiz/quiz03/pathB";
    }

    @GetMapping("/pathCommon/A")
    public String showCommonPageA(Model model) {
        model.addAttribute("title", "퀴즈 공통 페이지 A");
        model.addAttribute("info", "공통 A 상품정보: 스마트 워치");
        return "quiz/quiz03/pathCommonA";
    }

    @GetMapping("/pathCommon/B")
    public String showCommonPageB(Model model) {
        model.addAttribute("title", "퀴즈 공통 페이지 B");
        model.addAttribute("info", "공통 B 상품정보: 게이밍 키보드");
        return "quiz/quiz03/pathCommonB";
    }
}
