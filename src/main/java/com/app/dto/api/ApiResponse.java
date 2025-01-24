package com.app.dto.api;

import lombok.Data;

@Data
public class ApiResponse<T> {

	ApiResponseHeader header;
	T body;
	//제네릭 Generic
	
}
