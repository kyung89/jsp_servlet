<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	
	public String printBlank(int num) {
		if(num / 10 == 0) return "&nbsp&nbsp";
		else return "";
	}
	
	public String printByColumn(int column) {
		
		int ROW = 8 / column;
		if(8 % column != 0) ROW += 1;
		
		String str = "";
		
		for(int col = 0; col < ROW; col++) {
			for(int i = 1; i < 10; i++) { 
				for(int j = 2 + col * column; j < 10; j++) {
					if(j == 2 + (col+1) * column) break;
					str += (j + " * "  + i + " = " + (i * j) + "&nbsp&nbsp&nbsp&nbsp" + printBlank((i*j)));
				}
				str += ("<br/>");
			}
			str += ("<br/>");
		}
		
		return str;
	}
	%>
	<%
	// /gugudan2.jsp?col=3
	
	int col = Integer.parseInt(request.getParameter("col"));
	
	out.println(printByColumn(col));
	
	%>
</body>
</html>