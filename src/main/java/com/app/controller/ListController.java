package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.Member;

@Controller
public class ListController {

	@RequestMapping("/jstl/listTest")
    public String listTest(@RequestParam("type") String type, Model model) {
        if ("str".equals(type)) {
            // 스트링 리스트 생성 (Stream 활용)
            List<String> stringList = IntStream.range(0, 10)
                                               .mapToObj(i -> "스트링 리스트입니다.")
                                               .collect(Collectors.toList());
            model.addAttribute("stringList", stringList);
        } else if ("member".equals(type)) {
            // Member 리스트 생성 (Stream 활용)
            List<Member> memberList = IntStream.rangeClosed(1, 5)
                                               .mapToObj(i -> new Member("아이디" + i, "비번" + i, "이름" + i))
                                               .collect(Collectors.toList());
            model.addAttribute("memberList", memberList);
        }
        return "jstl/listTest"; // 뷰 반환
    }
}