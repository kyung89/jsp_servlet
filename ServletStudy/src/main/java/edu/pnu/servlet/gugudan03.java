package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/gugudan03")
public class gugudan03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();

		String dan = req.getParameter("dan");
		int ndan = 1;
		if (dan != null) {
			ndan = Integer.parseInt(dan);
		}
		
		out.println(printByColumn(ndan));
		
		out.close();
	}
	
	
}
