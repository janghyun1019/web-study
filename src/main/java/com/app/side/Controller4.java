package com.app.side;

import java.util.Map;

public class Controller4 {

	public String process(MyModel myModel) {
		
		MyModel model = new MyModel();
		
		model.addAttribute("key1", "value1");
		model.addAttribute("key2", "value122");
		model.addAttribute("key13", "value133");
		
		return "board/main";
	}
	
	public String process(MyModel myModel, Map<String, String> paramMap) {
		
		//paramMap.get("paramKey"); -> 처리 활용
		
		MyModel model = new MyModel();
		
		model.addAttribute("key1", "value1");
		model.addAttribute("key2", "value122");
		model.addAttribute("key13", "value133");
		
		return "board/main";
	}
}
