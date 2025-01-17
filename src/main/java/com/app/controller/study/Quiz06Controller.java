package com.app.controller.study;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.Member;

@Controller
public class Quiz06Controller {


	// /manage/member?auth=basic
	
	@GetMapping("/manage/member")
	public String member(@RequestParam String auth, Model model) {
		
		ArrayList<Member> memberList = new ArrayList<Member>();

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
		
		ArrayList<Member> viewMemberList = new ArrayList<Member>();
		
		/*
		for(Member member : memberList) {
			if(auth.equals(member.getType()) || auth.equals("admin")) {	//basic == basic    manager==manager
				viewMemberList.add(member);
			}
		}
		*/
		
		if(auth.equals("admin")) {
			viewMemberList = memberList;
		} else {
			for(Member member : memberList) {
				if(auth.equals(member.getType())) {	//basic == basic    manager==manager
					viewMemberList.add(member);
				}
			}			
		}
		
		/*
		for(Member member : memberList) {
			if(auth.equals("basic")) {
				if(member.getType().equals("basic")) {
					viewMemberList.add(member);
				}
			}
			
			if(auth.equals("manager")) {
				if(member.getType().equals("manager")) {
					viewMemberList.add(member);
				}
			}
			
			if(auth.equals("admin")) {
				viewMemberList.add(member);
			}
		}
		*/
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("auth", auth);
		
		model.addAttribute("viewMemberList", viewMemberList);
		
		return "quiz/quiz06/member";
	}
	
}
