package com.app.dto.study.api;

import com.app.dto.api.ApiResponseHeader;

import lombok.Data;

@Data
public class ApiResponseDelivery {

	ApiResponseHeader header;
	ApiDelivery body;
	//          data
}

