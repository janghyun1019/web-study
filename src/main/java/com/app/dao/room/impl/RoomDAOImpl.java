package com.app.dao.room.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;

//Data 읽어오는 역할 DB접근역할   DAO, Repository
// APIServiceRepository
@Repository   //Bean 등록 Annotation
public class RoomDAOImpl implements RoomDAO {

	@Autowired			
	SqlSessionTemplate sqlSessionTemplate;			

	
	@Override
	public List<Room> findRoomList() {
		
		System.out.println("RoomDAO 호출 됨");
		//db 연결 조회
		List<Room> roomList = sqlSessionTemplate.selectList("room_mapper.findRoomList");
		
		return roomList;
	}

	@Override
	public int saveRoom(Room room) {
		// DB 에 전달받은 Room 객체에 들어있는 데이터를 잘~ 저장 ~
		
		int result = sqlSessionTemplate.insert("room_mapper.saveRoom", room);
		
		return result;
	}

}
