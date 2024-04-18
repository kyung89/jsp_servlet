<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gugudan2</title>
</head>
<body>
	<%!	
	public String printByColumn(int column) {
		
		int ROW = 8 / column;
		if(8 % column != 0) ROW += 1;
		
		String str = "<pre>";
		
		for(int col = 0; col < ROW; col++) {
			for(int i = 1; i < 10; i++) { 
				for(int j = 2 + col * column; j < 10; j++) {
					if(j == 2 + (col+1) * column) break;
					str += (j + " * "  + i + " = " + (i * j) + "\t");
				}
				str += ("\n");
			}
			str += ("\n");
		}
		
		str += "</pre>";
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