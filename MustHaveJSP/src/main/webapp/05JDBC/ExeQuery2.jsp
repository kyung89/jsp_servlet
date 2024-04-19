<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="common.JDBConnect" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table, th, td {
	  border: 1px solid black;
	}
</style>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>ExeQuery2.jsp?id=musthave</h2>
	<h2>ExeQuery2.jsp?id=willhave</h2>
	<h2>ExeQuery2.jsp?id=dohave</h2>
	<%
	JDBConnect jdbc = new JDBConnect();
	
	String idparam = request.getParameter("id");
	
	String sql = "SELECT * FROM board WHERE id = '" + idparam + "'";
	Statement stmt = jdbc.con.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	out.println("<table>");
	out.println("<tr>");
	out.println("<th>" + "num" + "</th>");
	out.println("<th>" + "title" + "</th>");
	out.println("<th>" + "content" + "</th>");
	out.println("<th>" + "id" + "</th>");
	out.println("<th>" + "postdate" + "</th>");
	out.println("<th>" + "visitcount" + "</th>");
	out.println("</tr>");
	while(rs.next()) {
		String num = rs.getString("num");
		String title = rs.getString("title");
		String content = rs.getString("content");
		String id = rs.getString("id");
		java.sql.Date postdate = rs.getDate("postdate");
		String visitcount = rs.getString("visitcount");
		
		out.println("<tr>");
		//out.println(String.format("%s %s %s %s %s %s", num, title, content, id, postdate, visitcount) + "<br/>");
		out.println("<td>" + num + "</td>");
		out.println("<td>" + title + "</td>");
		out.println("<td>" + content + "</td>");
		out.println("<td>" + id + "</td>");
		out.println("<td>" + postdate + "</td>");
		out.println("<td>" + visitcount + "</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	jdbc.close();
	%>
</body>
</html>