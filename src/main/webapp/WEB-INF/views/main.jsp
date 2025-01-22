<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지</h1>
	<h2>고객이 접속해서 보는 페이지</h2>
	
	<c:if test="${loginUserId == null }">
		<button onClick="location.href='/customer/signup'">회원가입</button>
		<button onClick="location.href='/customer/login'">로그인</button>
	</c:if>
	
	<c:if test="${loginUserId != null }">
		<span>${loginUserId}님 환영합니다!</span>
		<button onClick="location.href='/customer/logout'">로그아웃</button>
		<button onClick="location.href='/customer/mypage'">Mypage</button>
	</c:if>
	
</body>
</html>