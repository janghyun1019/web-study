package com.app.controller;

import com.app.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MemberController {

    private List<Member> memberList;

    public MemberController() {
        memberList = new ArrayList<>();
        memberList.add(new Member("user1", "pass123", "홍길동", "basic"));
        memberList.add(new Member("user2", "pass456", "김철수", "manager"));
        memberList.add(new Member("user3", "pass789", "이영희", "basic"));
        memberList.add(new Member("user4", "passabc", "박민지", "manager"));
        memberList.add(new Member("user5", "passdef", "정재영", "basic"));
        memberList.add(new Member("user6", "passxyz", "최성민", "basic"));
        memberList.add(new Member("user7", "pass123", "서지원", "manager"));
        memberList.add(new Member("user8", "pass456", "장성호", "basic"));
        memberList.add(new Member("user9", "pass789", "신지수", "basic"));
        memberList.add(new Member("user10", "passabc", "한영희", "manager"));
    }

    @GetMapping("/manage/member")
    public String getMembers(@RequestParam String auth, Model model) {
        List<Member> filteredMembers;

        if ("basic".equals(auth)) {
            filteredMembers = memberList.stream()
                    .filter(member -> "basic".equals(member.getType()))
                    .collect(Collectors.toList());
        } else if ("manager".equals(auth)) {
            filteredMembers = memberList.stream()
                    .filter(member -> "manager".equals(member.getType()))
                    .collect(Collectors.toList());
        } else {
            filteredMembers = new ArrayList<>(memberList);
        }

        model.addAttribute("members", filteredMembers);
        return "member/memberList";
    }
}
