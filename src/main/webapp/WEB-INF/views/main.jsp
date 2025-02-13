<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		color:red;
	}
</style>

<!-- <link href="../../resources/css/main.css" rel="stylesheet"> -->
	<link href="/css/main.css" rel="stylesheet">

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
	
	<img src="/image/001.png" >
<!-- 	<img src="https://media.istockphoto.com/id/1676101015/ko/%EC%82%AC%EC%A7%84/%EA%B2%BD%EB%B3%B5%EA%B6%81%EC%9D%80-%EC%84%9D%EC%96%91%EC%9D%B4-%EC%95%84%EB%A6%84%EB%8B%B5%EA%B3%A0-%EC%84%9C%EC%9A%B8-%EB%8C%80%ED%95%9C%EB%AF%BC%EA%B5%AD.jpg?s=1024x1024&w=is&k=20&c=swWJjHRO5tNI8mVeh-YzC-4utgsYAsVoUOg_S8kn0po="> -->
	
	<script>
		console.log('main 페이지 접속 콘솔 로그');
	</script>
	
	<script src="/js/main.js"></script>
	
</body>
</html>