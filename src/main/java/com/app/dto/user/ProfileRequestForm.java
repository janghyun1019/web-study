package com.app.dto.user;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProfileRequestForm {

	String id;
	String name;
	MultipartFile profileImage;
}
