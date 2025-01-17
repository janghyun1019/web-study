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
	
	<c:if test="${loginId == null}">
		<h1> 접속한 사용자가 없습니다 </h1>
<!-- 	 	<h2> 접속 횟수 : 0 </h2> -->
	</c:if>
	
	<c:if test="${loginId != null}">
		<h1> ${loginId} 님이 접속하셨습니다! </h1>
<%-- 		<h2> 접속 횟수 : ${count} </h2> --%>
	</c:if>
	
	<h2> 접속 횟수 : ${count} </h2>
	 
</body>
</html>