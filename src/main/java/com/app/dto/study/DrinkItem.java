package com.app.dto.study;

public class DrinkItem {
	String item;
	String type;
	
	public DrinkItem() {}
	
	public DrinkItem(String item, String type) {
		super();
		this.item = item;
		this.type = type;
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
