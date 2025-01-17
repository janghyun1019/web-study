<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
    <form action="/quiz/session/login" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <button type="submit">Login</button>
    </form>
    <c:if test="${param.error != null}">
        <p style="color: red;">Invalid ID or Password</p>
    </c:if>
</body>
</html>