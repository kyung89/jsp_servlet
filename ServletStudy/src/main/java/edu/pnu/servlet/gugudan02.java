package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/gugudan02")
public class gugudan02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();

		String dir = req.getParameter("dir");
		if(dir == null) dir = "ver";
		
		if(dir.equals("ver")) {
			out.println("<pre>");
			for (int j = 2; j <= 9; j++) {
				for (int i = 1; i <= 9; i++) {
					out.print(j + " * " + i + " = " + (j * i) + "\n");
				}
				out.println("");
			}
			out.println("</pre>");
		}
		
		if(dir.equals("hor")) {
			out.println("<pre>");
			for (int i = 1; i <= 9; i++) {
				for (int j = 2; j <= 9; j++) {
					out.print(j + " * " + i + " = " + (j*i) + "\t");
				}
				out.println("");
			}
			out.println("</pre>");
		}
		
		out.close();
	}
	
	
}
