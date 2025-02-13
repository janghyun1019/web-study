CREATE TABLE T_ROOM (
	room_id NUMBER Primary key,
	building_number VARCHAR2(32) NOT NULL,
	room_number NUMBER(6) NOT NULL,
	floor NUMBER(4),
	max_guest_count NUMBER(6) NOT NULL,
	view_type VARCHAR2(8) NOT NULL
);

CREATE SEQUENCE SEQ_T_ROOM_PK
START WITH 1
INCREMENT BY 1
NOCYCLE;

CREATE TABLE T_USER (
	id VARCHAR2(32) Primary key,
	pw VARCHAR2(32) ,
	name VARCHAR2(32) NOT NULL,
	user_type VARCHAR(8) NOT NULL
);



CREATE TABLE file_info (
	file_name VARCHAR2(256),
	original_file_name VARCHAR2(256),
	file_path VARCHAR2(256),
	url_file_path VARCHAR2(256)
);


CREATE TABLE USER_PROFILE_IMAGE (
    id VARCHAR2(32 BYTE),
    file_name VARCHAR2(256)
);