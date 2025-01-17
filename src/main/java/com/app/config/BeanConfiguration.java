package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.dao.room.RoomDAO;
import com.app.dao.room.impl.RoomDAOImpl;
import com.app.service.room.RoomService;
import com.app.service.room.impl.RoomServiceImpl;

//@Configuration
public class BeanConfiguration {
	
	
	// RoomDAO roomDAO = new RoomDAOImpl();
	
	@Bean
	public RoomDAO roomDAO() {
		return new RoomDAOImpl();
	}
	
	@Bean
	public RoomService roomService(RoomDAO roomDAO) {
		
		//set 통해서 주입
		/*
		RoomServiceImpl roomService = new RoomServiceImpl();
		roomService.setRoomDAO(roomDAO);
		
		return roomService;
		*/
		//생성자 통해서 주입
		//return new RoomServiceImpl(roomDAO);
		return null;
	}
}
