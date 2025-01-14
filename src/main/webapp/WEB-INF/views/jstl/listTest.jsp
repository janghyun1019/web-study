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
	<h1>listTest</h1>
	
<!-- 	1) 고정된 메시지 10개 -->
<%-- 	<c:if test="${type=='str'}"> --%>
<!-- 		<p>스트링 리스트입니다.</p> -->
<!-- 		<p>스트링 리스트입니다.</p> -->
<!-- 		<p>스트링 리스트입니다.</p> -->
<!-- 		<p>스트링 리스트입니다.</p> -->
<!-- 		<p>스트링 리스트입니다.</p> -->
<!-- 		<p>스트링 리스트입니다.</p> -->
<!-- 		<p>스트링 리스트입니다.</p> -->
<!-- 		<p>스트링 리스트입니다.</p> -->
<!-- 		<p>스트링 리스트입니다.</p> -->
<!-- 		<p>스트링 리스트입니다.</p> -->
<%-- 	</c:if> --%>
	
<!-- 	2) 고정된 메시지 10번 반복 -->
<%-- 	<c:if test="${type=='str'}"> --%>
<%-- 		<c:forEach var="i" begin="1" end="10" step="1"> --%>
<!-- 			<p>스트링 리스트입니다.</p> -->
<%-- 		</c:forEach> --%>
<%-- 	</c:if> --%>
	
<!-- 	3) 화면에 전달된 메시지 10번 반복 -->
<%-- 	<c:if test="${type=='str'}"> --%>
<%-- 		<c:forEach var="i" begin="1" end="10" step="1"> --%>
<%-- 			<p>${msg}</p> --%>
<%-- 		</c:forEach> --%>
<%-- 	</c:if> --%>
	
<!-- 	4) list로 전달받아서 list를 반복 -->
	<c:if test="${type=='str'}">
		<c:forEach var="item" items="${msgList}">
			<p>${item}</p>
		</c:forEach>
	</c:if>
	
	<c:if test="${type=='member'}">
		<c:forEach var="member" items="${memberList}">
			<p>${member.id} ${member.pw} ${member.name}</p>
		</c:forEach>
	</c:if>
</body>
</html>