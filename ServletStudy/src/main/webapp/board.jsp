<%@ page import="model1.board.BoardDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
</head>
<body>
	<table border=1>
	<tr>
		<td>NUM</td>
		<td>TITLE</td>
		<td>CONTENT</td>
		<td>ID</td>
		<td>POSTDATE</td>
		<td>VISITCOUNT</td>
		<td>NAME</td>
	</tr>
	<c:forEach items="${ list }" var="item">
	<tr>
		<td>${ item.getNum() }</td>
		<td>${ item.getTitle() }</td>
		<td>${ item.getContent() }</td>
		<td>${ item.getId() }</td>
		<td>${ item.getPostdate() }</td>
		<td>${ item.getVisitcount() }</td>
		<td>${ item.getName() }</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>