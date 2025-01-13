<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>BMI 계산기</h1>
    <form action="result-bmi" method="post">
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="height">키(cm):</label>
        <input type="number" id="height" name="height" step="0.1" required><br><br>

        <label for="weight">체중(kg):</label>
        <input type="number" id="weight" name="weight" step="0.1" required><br><br>

        <button type="submit">결과 확인</button>
    </form>
	
</body>
</html>