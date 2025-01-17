package com.app.controller.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz03")
public class Quiz03Controller {

	
	//1) 4개 경로 각자 개별 페이지 보유 한 버전
	/*
	@RequestMapping("/pathA")
	public String pathA() {
		return "quiz/quiz03/pathA";
	}
	
	@RequestMapping("/pathB")
	public String pathB() {
		return "quiz/quiz03/pathB";
	}
	
	@RequestMapping("/pathCommon/A")
	public String pathCommonA() {
		return "quiz/quiz03/pathCommon/A";
	}
	
	@RequestMapping("/pathCommon/B")
	public String pathCommonB() {
		return "quiz/quiz03/pathCommon/B";
	}
	*/
	
	//2)pathA, pathB 는 각각 페이지 보유.
	// pathCommon은 동일한 페이지로 연결
	
	@RequestMapping("/pathA")
	public String pathA() {
		return "quiz/quiz03/pathA";
	}
	
	@RequestMapping("/pathB")
	public String pathB() {
		return "quiz/quiz03/pathB";
	}
	
	/*
	@RequestMapping("/pathCommon/A")
	public String pathCommonA(HttpServletRequest request) {
		request.setAttribute("productName", "A라는 상품의 상품명");
		return "quiz/quiz03/pathCommon/common";
	}
	
	@RequestMapping("/pathCommon/B")
	public String pathCommonB(Model model) {
		model.addAttribute("productName", "B 상품 이름");
		return "quiz/quiz03/pathCommon/common";
	}*/
	@RequestMapping("/pathCommon/{pathName}")
	public String pathCommonA(@PathVariable String pathName, Model model) {
		//pathName : A B C D  E F G .... Z
		
		// pathName 활용해서 -> DB 데이터 조회 -> 화면 전달
		model.addAttribute("productName", pathName);
		
		return "quiz/quiz03/pathCommon/common";
	}
	
	
	
	//3) 모든 경로가 동일한 페이지로 연결
	/*
	@RequestMapping("/pathA")
	public String pathA(HttpServletRequest request) {
		request.setAttribute("productName", "A라는 상품의 상품명");
		return "quiz/quiz03/pathCommon/common";
	}
	
	@RequestMapping("/pathB")
	public String pathB(Model model) {
		model.addAttribute("productName", "B 상품 이름");
		return "quiz/quiz03/pathCommon/common";
	}
	
	@RequestMapping("/pathCommon/A")
	public String pathCommonA(HttpServletRequest request) {
		request.setAttribute("productName", "A라는 상품의 상품명");
		return "quiz/quiz03/pathCommon/common";
	}
	
	@RequestMapping("/pathCommon/B")
	public String pathCommonB(Model model) {
		model.addAttribute("productName", "B 상품 이름");
		return "quiz/quiz03/pathCommon/common";
	}
	*/
	
	//4) A는 A끼리, B는 B끼리 페이지 연결
	/*
	@RequestMapping("/pathA")
	public String pathA(HttpServletRequest request) {
		return "quiz/quiz03/pathA";
	}
	
	@RequestMapping("/pathB")
	public String pathB() {
		return "quiz/quiz03/pathB";
	}
	
	@RequestMapping("/pathCommon/A")
	public String pathCommonA() {
		return "quiz/quiz03/pathA";
	}
	
	@RequestMapping("/pathCommon/B")
	public String pathCommonB() {
		return "quiz/quiz03/pathB";
	}
	*/
	/*
	@RequestMapping(value = {"/pathA", "/pathCommon/A"})
	public String pathA(HttpServletRequest request) {
		return "quiz/quiz03/pathA";
	}
	
	@RequestMapping(value = { "/pathB", "/pathCommon/B"})
	public String pathB() {
		return "quiz/quiz03/pathB";
	}
	*/

	
}
