<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String sel = request.getParameter("sel");
String val = request.getParameter("val");

if ("type1".equals(sel)) {
	response.sendRedirect(request.getContextPath() +"/gugudan1.jsp?dan=" + val);
} 
if ("type2".equals(sel)) {
	response.sendRedirect(request.getContextPath() +"/gugudan2.jsp?col=" + val);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gugudanMain</title>
</head>
<body>

</body>
</html>