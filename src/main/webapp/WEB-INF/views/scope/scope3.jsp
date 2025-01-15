<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scope3 page</h1>
	<p>${requestMsg}</p>
	<p>${requestScope.requestMsg}</p>
	
	<p>${sessionMsg}</p>
	<p>${seccionScope.sessionMsg}</p>
	<!-- 내가 요청하는 세션영역에 저장이 된다 -->
</body>
</html>