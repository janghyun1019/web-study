package com.app.controller.study.quiz10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.controller.study.quiz10.dto.Quiz10Room;
import com.app.controller.study.quiz10.service.Quiz10RoomService;

@Controller
public class Quiz10RoomController {

	@Autowired
	Quiz10RoomService quiz10RoomService;
	
	@GetMapping("/quiz10registerRoom")
	public String quiz10registerRoom() {
		return "quiz/quiz10/quiz10registerRoom";
	}
	
	@PostMapping("/quiz10registerRoom")
	public String quiz10registerRoomAction(Quiz10Room quiz10Room) {
		
		int result = quiz10RoomService.saveRoom(quiz10Room);
		
		
		return "quiz/quiz10/quiz10registerRoom";
	}
}
