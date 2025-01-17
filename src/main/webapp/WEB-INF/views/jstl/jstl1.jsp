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
	<h1>jstl1</h1>
	
	${msg}
	
	<c:out value="${msg}"/>
	
	${d1.item} ${d1.type}
	
	${drinkList[0].item}
	${drinkList.get(1).item}
	
	
	
	<div class="itemBox">
		<h3>${drinkList[0].item}</h3>
		<p>${drinkList[0].type}</p>
	</div>
	<div class="itemBox">
		<h3>${drinkList[1].item}</h3>
		<p>${drinkList[1].type}</p>
	</div>
	<div class="itemBox">
		<h3>${drinkList[2].item}</h3>
		<p>${drinkList[2].type}</p>
	</div>
	<div class="itemBox">
		<h3>${drinkList[3].item}</h3>
		<p>${drinkList[3].type}</p>
	</div>
	
	<hr>
	<hr>
	
<!-- 	for(int i=1; i<=5; i++) -->
	<c:forEach var="i" begin="1" end="5" step="1">
		<p>반복됨 ${i}</p>
	</c:forEach>
	
<!-- 	for(DrinkItem drinkItem : drinkList) -->
	<c:forEach var="drinkItem" items="${drinkList}">
		<div class="itemBox">
			<h3>${drinkItem.item}</h3>
			<p>${drinkItem.type}</p>
		</div>
	</c:forEach>
	
	<c:choose>
		<c:when test="${ userType == 'user' }">
			<p>일반사용자입니다</p>
		</c:when>
		<c:when test="${ userType == 'admin' }">
			<p>관리자입니다</p>
		</c:when>
		<c:otherwise>
			<p>정체불명입니다</p>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${ userType == 'user' }">
		<p>환영합니다</p>
	</c:if>
	
	<c:if test="${ userType == 'admin' }">
		<button>상품관리하기</button>
	</c:if>
	
	<c:if test="${isLogin == true }">
		<button>로그아웃</button>
	</c:if>
	
	<c:if test="${isLogin == false }">
		<button>로그인</button>
	</c:if>
	
</body>
</html>