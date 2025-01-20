package com.app.controller.study.quiz10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controller.study.quiz10.dao.Quiz10RoomDAO;
import com.app.controller.study.quiz10.dto.Quiz10Room;

@Service
public class Quiz10RoomServiceImpl implements Quiz10RoomService {

	@Autowired
	Quiz10RoomDAO quiz10RoomDAO;
	
	@Override
	public int saveRoom(Quiz10Room quiz10Room) {
		
		int result = quiz10RoomDAO.saveRoom(quiz10Room);
		
		return result;
	}
	
}
