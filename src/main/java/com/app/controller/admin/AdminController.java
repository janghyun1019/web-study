package com.app.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.common.CommonCode;
import com.app.dto.room.Room;
import com.app.dto.user.User;
import com.app.service.room.RoomService;
import com.app.service.user.UserService;

@Controller
public class AdminController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	UserService userService;

	//객실 등록
	@GetMapping("/admin/registerRoom")
	public String registerRoom() {
		return "admin/registerRoom";
	}
	
	@PostMapping("/admin/registerRoom")
	public String registerRoomAction(Room room) {
		
		//값 넘어온거 확인
		System.out.println(room.toString());
		//등록
		int result = roomService.saveRoom(room);
		System.out.println(result);
		
		if(result > 0) {
			return "redirect:/admin/rooms";
		} else {
			return "admin/registerRoom";	
		}
		
	}
	
	//관리자 객실 목록 확인
	@GetMapping("/admin/rooms")
	public String rooms(Model model) {
		
		List<Room> roomList = roomService.findRoomList();
		//service.findRoomList 호출 -> DAO findRoomList -> DB (Mybatis mapper) select 
		//						<- List<Room>			<- List<Room>
		// Controller DB로부터 조회 데이터 -> 화면 전달 -> 화면 출력(표시)
		model.addAttribute("roomList", roomList);
			
		return "admin/rooms";
	}
	
	//관리자 특정 객실에 대한 정보 (상세페이지)
	
	//
	//    /admin/roomInfo?roodId=2
	//    /admin/roomInfo?roodId=1
	//    /admin/roomInfo?roodId=40
	//@GetMapping("/admin/roomInfo")  

	//  /admin/room/2
	//  /admin/room/50
	//  /admin/room/99
	@GetMapping("/admin/room/{roomId}")
	public String room(@PathVariable String roomId, Model model) {
		
		int roomIdInt = Integer.parseInt(roomId);
		
		Room room = roomService.findRoomByRoomId(roomIdInt);
		model.addAttribute("room", room);
		
		return "admin/room";
	}
	
	
	//객실 정보 삭제
	@GetMapping("/admin/removeRoom")
	public String removeRoom(HttpServletRequest request) {
		String roomId = request.getParameter("roomId");
		
		int roomIdInt = Integer.parseInt(roomId);
		
		int result = roomService.removeRoom(roomIdInt);
		
		return "redirect:/admin/rooms";
//		if(result > 0) {
//			
//		} else {
//			
//		}
	}
	
	//객실 정보 수정
	@GetMapping("/admin/modifyRoom")
	public String modifyRoom(HttpServletRequest request) {
		String roomId = request.getParameter("roomId");
		int roomIdInt = Integer.parseInt(roomId);
		//roomId -> 해당 호실에 대한 정보 조회
		// 화면에 세팅
		Room room = roomService.findRoomByRoomId(roomIdInt);
		
		request.setAttribute("room", room);
		
		return "admin/modifyRoom";
	}
	
	@PostMapping("/admin/modifyRoom")
	public String modifyRoomAction(Room room) {
		//roomId
		
		System.out.println(room);
		int result = roomService.modifyRoom(room);
		
		if(result > 0 ) { //수정 성공 -> 목록 or 호실상세정보 페이지
			return "redirect:/admin/room/" + room.getRoomId();		
		} else {  //수정 실패 -> 다시 수정페이지로
			//return "admin/modifyRoom";
			return "redirect:/admin/modifyRoom?roomId=" + room.getRoomId();
		}
		
	}
	
	
	
	//고객 관리/등록
	
	@GetMapping("/admin/users/add")
	public String addUser() {
		
		return "admin/addUser";
	}
	
	@PostMapping("/admin/users/add")
	public String addUserAction(User user) {
		//사용자 추가 (관리자X)
		
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userService.saveUser(user);
		//int result = userService.saveCustomerUser(user);
		System.out.println("사용자 추가 처리 결과 : " + result);
		
		if(result > 0) {
			return "redirect:/admin/users";
		} else {
			return "admin/addUser";			
		}
	}
	
	@GetMapping("/admin/users")
	public String users(Model model) {
		
		List<User> userList = userService.findUserList();
		
		model.addAttribute("userList", userList);
		
		return "admin/users";
		
	}
	
	
	
	
}
