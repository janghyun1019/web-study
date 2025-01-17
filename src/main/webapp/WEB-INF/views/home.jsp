<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Home 페이지</h1>
	
	<p><a href="/board/faq">faq 로 이동</a></p>
	<p><a href="/board/notice">공지사항으로 이동</a></p>
	<p><a href="/member/signup">회원가입으로 이동</a></p>
	<div>
		<button onclick="location.href = '/member/signup'">회원가입</button>
		<button id="btn_faq">FAQ확인</button>
	</div>
	
	<div>
		<form action="/board/notice" method="get">
			<input type="text" >
			<input type="submit" value="공지사항확인">
		</form>
	</div>
	
	<script>
	
		document.getElementById("btn_faq").addEventListener('click', ()=>{
			location.href = "/board/faq";
		});
	
	</script>
</body>
</html>