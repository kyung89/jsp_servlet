package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/gugudan01")
public class gugudan01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();

		String snum = req.getParameter("num");
		int num = 2;
		if (snum != null) {
			num = Integer.parseInt(snum);
		}
		
		out.println("<h2>"+num+"단 입니다.</h2>");
		out.println("<ul>");
		for (int i = 1; i <= 9; i++) {
			out.println("<li>" + num + " * " + i + " = " + (num * i) + "</li>");
		}
		out.println("</ul>");
		
		out.close();
	}
	
	
}
