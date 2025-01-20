package com.app.service.room.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;
import com.app.service.room.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired  //의존성 주입 어노테이션 	
	RoomDAO roomDAO;
	
	//생성자를 통한 주입
	/*
	public RoomServiceImpl(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
	*/
	
	
	//set 을 통한 주입
	/*
	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
	*/
	
	@Override
	public List<Room> findRoomList() {
		System.out.println("RoomService 호출 됨");
		
		List<Room> roomList = roomDAO.findRoomList();
		
		
		return roomList;
	}

	@Override
	public int saveRoom(Room room) {
		
		int result = roomDAO.saveRoom(room);
		
		return result;
	}

}
