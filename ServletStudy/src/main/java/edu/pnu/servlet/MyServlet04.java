package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/myservlet04")
public class MyServlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MyServlet04");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String[][] data = {{"번호","나라","수도"},{"1","대한민국","서울"},{"2","미국","워싱턴"},{"3","일본","도쿄"},{"4","중국","베이징"}};
		
		out.println("<table border=1>");
		
		for (String[] d : data) {
			out.println("<tr>");
			out.println("<td>"+d[0]+"</td>");
			out.println("<td>"+d[1]+"</td>");
			out.println("<td>"+d[2]+"</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		
		out.close();
	}
	
	
}
