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
	<h1>quiz06 manage member</h1>
	
	<c:choose>
		<c:when test="${auth == 'basic'}">
			<c:forEach var="member" items="${memberList}">
				<c:if test="${member.type == 'basic'}">
					<p>${member.id} ${member.pw} ${member.name} ${member.type}</p>
				</c:if>
			</c:forEach>
		</c:when>
		
		<c:when test="${auth == 'manager'}">
			<c:forEach var="member" items="${memberList}">
				<c:if test="${member.type == 'manager'}">
					<p>${member.id} ${member.pw} ${member.name} ${member.type}</p>
				</c:if>
			</c:forEach>
		</c:when>

		<c:when test="${auth == 'admin'}">
			<c:forEach var="member" items="${memberList}">
				<p>${member.id} ${member.pw} ${member.name} ${member.type}</p>
			</c:forEach>
		</c:when>
	
	</c:choose>
	
	<hr>
	<h2>Controller 에서 필터링 후 리스트 넘어왔을때</h2>
	
	<c:forEach var="member" items="${viewMemberList}">
		<p>${member.id} ${member.pw} ${member.name} ${member.type}</p>
	</c:forEach>
	
</body>
</html>