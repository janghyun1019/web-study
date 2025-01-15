<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Member List</title>
</head>
<body>
    <h1>Member List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Type</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td>${member.id}</td>
                    <td>${member.name}</td>
                    <td>${member.type}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
