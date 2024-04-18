<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gugudan1</title>
</head>
<body>
	<%
	// /gugudan1.jsp?dan=2
	
	int dan = Integer.parseInt(request.getParameter("dan"));
	
	for(int i = 1; i < 10; i++) {
		out.println(dan + " * " + i + " = " + (dan * i) + "<br/>");
	}
	
	%>
</body>
</html>