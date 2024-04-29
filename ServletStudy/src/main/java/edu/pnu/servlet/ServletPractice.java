package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import membership.MemberDAO;
import membership.MemberDTO;
import model1.board.BoardDAO;
import model1.board.BoardDTO;

@WebServlet("/musthave")
public class ServletPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;
	BoardDAO boardDAO;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ServletContext application = this.getServletContext();
		
		memberDAO = new MemberDAO(application);
		boardDAO = new BoardDAO(application);
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		String table = req.getParameter("table");
		if (table == null) table = "member";
		
		if(table.equals("member")) {
			
			ArrayList<MemberDTO> list = memberDAO.getMembers();
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("/member.jsp").forward(req, resp);
		}
		
		if(table.equals("board")) {
			
			ArrayList<BoardDTO> list = boardDAO.getBoards();
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("/board.jsp").forward(req, resp);
		}
		
		resp.setContentType("text/plain; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("이것은 서블릿에서 출력하는 문서입니다.");
		out.println("잘 보이면 성공");
		out.close();
	}
	
	
}