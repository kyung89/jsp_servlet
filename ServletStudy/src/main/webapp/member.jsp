<%@ page import="membership.MemberDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member.jsp</title>
</head>
<body>
	
	<table border=1>
	<tr>
		<td>ID</td>
		<td>PASS</td>
		<td>NAME</td>
		<td>REGIDATE</td>
	</tr>
	<c:forEach items="${ list }" var="item">
		<tr>
		<td>${ item.getId() }</td>
		<td>${ item.getPass() }</td>
		<td>${ item.getName() }</td>
		<td>${ item.getRegidate() }</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>