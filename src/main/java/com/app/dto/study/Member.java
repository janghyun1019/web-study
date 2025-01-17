package com.app.dto.study;

public class Member {
	String id;
	String pw;
	String name;
	String type;
	
	public Member() {}
	
	public Member(String id, String pw, String name, String type) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.type = type;
	}
	
	public Member(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
