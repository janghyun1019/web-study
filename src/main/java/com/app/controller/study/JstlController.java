package com.app.controller.study;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.DrinkItem;
import com.app.dto.study.Member;

@Controller
public class JstlController {

	@GetMapping("/jstl1")
	public String jstl1(Model model) {

		model.addAttribute("msg", "이것은 메시지다");

		DrinkItem d1 = new DrinkItem();
		d1.setItem("아메리카노");
		d1.setType("커피");

		model.addAttribute("d1", d1);

		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		drinkList.add(new DrinkItem("카페라떼", "커피"));
		drinkList.add(new DrinkItem("카페모카", "커피"));
		drinkList.add(new DrinkItem("카푸치노", "커피"));
		drinkList.add(new DrinkItem("아이스티", "차"));
		drinkList.add(new DrinkItem("레몬티", "차"));
		drinkList.add(new DrinkItem("얼그레이티", "차"));

		model.addAttribute("drinkList", drinkList);
		model.addAttribute("listSize", drinkList.size());

		//  ${listSize}

		// userType : "user" "admin"
		model.addAttribute("userType", "admin");  

		model.addAttribute("isLogin", true);	//true O  false X

		return "jstl/jstl1";
	}

	@GetMapping("/jstl2")
	public String jstl2(Model model) {

		//  안녕하세요~?
		//  안녕하세요~? (*빨간글자)
		//  <span class='fontred'>안녕하세요~?</span>

		model.addAttribute("msg1", "<부등호>");
		model.addAttribute("msg2", "&lt;부등호&gt;");


		model.addAttribute("msgXml", "<script>alert('경고')</script>");

		return "jstl/jstl2";
	}


	//  /jstl/listTest?type=str
	//  /jstl/listTest?type=member
	@GetMapping("/jstl/listTest")
	public String listTest(@RequestParam String type, Model model) {

		//  /jstl/listTest?type=str
		//  /jstl/listTest?type=member

		//1) 전부 화면에 전달
		/*
		model.addAttribute("type", type);

		model.addAttribute("msg", "스트링 리스트입니다.");

		List<String> msgList = new ArrayList<String>();
		for(int i=1; i<=15; i++)
			msgList.add("스트링 리스트입니다.");

		model.addAttribute("msgList", msgList);


		List<Member> memberList = new ArrayList<Member>();

		for(int i=1; i<=5; i++) {
			memberList.add(new Member("아이디"+i, "비번"+i, "이름"+i));
		}

		model.addAttribute("memberList", memberList);
		 */

		//2) 각 type 파라미터에 따라 경우에 맞는 작업만 수행
		/*
		model.addAttribute("type", type);

		if(type.equals("str")) {
			model.addAttribute("msg", "스트링 리스트입니다.");

			List<String> msgList = new ArrayList<String>();
			for(int i=1; i<=15; i++)
				msgList.add("스트링 리스트입니다.");

			model.addAttribute("msgList", msgList);
		}

		if(type.equals("member")) {
			List<Member> memberList = new ArrayList<Member>();

			for(int i=1; i<=5; i++) {
				memberList.add(new Member("아이디"+i, "비번"+i, "이름"+i));
			}

			model.addAttribute("memberList", memberList);
		}


		return "jstl/listTest";
		 */

		//3) type별로 아예 페이지 자체를 나누어처리 하는 경우
		if(type.equals("str")) {
			model.addAttribute("msg", "스트링 리스트입니다.");

			List<String> msgList = new ArrayList<String>();
			for(int i=1; i<=15; i++)
				msgList.add("스트링 리스트입니다.");

			model.addAttribute("msgList", msgList);

			return "jstl/str";
		} else {		
			//if(type.equals("member")) {
			List<Member> memberList = new ArrayList<Member>();

			for(int i=1; i<=5; i++) {
				memberList.add(new Member("아이디"+i, "비번"+i, "이름"+i));
			}

			model.addAttribute("memberList", memberList);

			return "jstl/member";
		}

		//return "jstl/listTest"; //잘못 접근 시 보여줄 페이지
	}

	@GetMapping("/jstl/listTest/{type}")
	public String listTestPath(@PathVariable String type, Model model) {

		if(type.equals("str")) {
			model.addAttribute("msg", "스트링 리스트입니다.");

			List<String> msgList = new ArrayList<String>();
			for(int i=1; i<=15; i++)
				msgList.add("스트링 리스트입니다.");

			model.addAttribute("msgList", msgList);

			return "jstl/str";
		} else {		
			//if(type.equals("member")) {
			List<Member> memberList = new ArrayList<Member>();

			for(int i=1; i<=5; i++) {
				memberList.add(new Member("아이디"+i, "비번"+i, "이름"+i));
			}

			model.addAttribute("memberList", memberList);

			return "jstl/member";
		}

	}
	
	/*
	@GetMapping("/jstl/listTest/str")
	public String listTestStr(Model model) {
		model.addAttribute("msg", "스트링 리스트입니다.");

		List<String> msgList = new ArrayList<String>();
		for(int i=1; i<=15; i++)
			msgList.add("스트링 리스트입니다.");

		model.addAttribute("msgList", msgList);

		return "jstl/str";
	}

	@GetMapping("/jstl/listTest/member")
	public String listTestMember(Model model) {

		List<Member> memberList = new ArrayList<Member>();

		for(int i=1; i<=5; i++) {
			memberList.add(new Member("아이디"+i, "비번"+i, "이름"+i));
		}

		model.addAttribute("memberList", memberList);

		return "jstl/member";

		//return "jstl/listTest"; //잘못 접근 시 보여줄 페이지
	}
	 */

}

