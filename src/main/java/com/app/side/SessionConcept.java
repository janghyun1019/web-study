package com.app.side;

import java.util.HashMap;
import java.util.Map;

public class SessionConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//JSESSIONID 쿠키값 -> 내 session 영역 접근 -> session.setAttribute
		
		//key:jsessionId 값, value : 저장공간(storage)
		Map<String, SessionStorage> sessionMap
							= new HashMap<String, SessionStorage>();
		
		sessionMap.put("123A123", new SessionStorage());
		
		SessionStorage session = sessionMap.get("123A123");
		session.setAttribute("sessionMsg", "여기다 세션 메시지");
		
		sessionMap.put("BBB222", new SessionStorage());
		
		sessionMap.get("123A123");
		sessionMap.get("BBB222");
		
		sessionMap.get("E7A328CF007EF2A3685CEEEADE0466FE");
		//A80C0350B8704626FD8DF248257C0825
	}

}

class SessionStorage {
	
	Map<String, String> storage;
	
	public SessionStorage() {
		storage = new HashMap<String, String>();
	}
	
	public void setAttribute(String key, String value) {
		storage.put(key, value);
	}
	
	public void removeAttribute(String key) {
		storage.remove(key);
	}
	
	public void invalidate() {
		storage.clear();
	}
}