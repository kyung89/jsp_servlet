package servlet;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import membership.MemberDAO;
import membership.MemberDTO;

@WebServlet(
		urlPatterns = "/12Servlet/MemberAuth.mvc",
		initParams = { @WebInitParam(name="admin_id", value="nakja") } )
public class MemberAuth extends HttpServlet {

	private static final long serialVersionUID = 1L;
	MemberDAO dao;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String admin_id = this.getInitParameter("admin_id");
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		MemberDTO memberDTO = dao.getMemberDTO(id, pass);
		
		String memberName = memberDTO.getName();
		if (memberName != null) {
			req.setAttribute("authMessage", memberName + " 회원님 방가방가^^*");
		} else {
			if (admin_id.equals(id))
				req.setAttribute("authMessage", admin_id + " 는 최고 관리자입니다.");
			else 
				req.setAttribute("authMessage", "귀하는 회원이 아닙니다.");
		}
		req.getRequestDispatcher("/12Servlet/MemberAuth.jsp").forward(req, resp);
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		dao.close();
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ServletContext application = this.getServletContext();
		
		String driver = application.getInitParameter("MySQLDriver");
		String connectUrl = application.getInitParameter("MySQLURL");
		String oId = application.getInitParameter("MySQLId");
		String oPass = application.getInitParameter("MySQLPwd");
		
		dao = new MemberDAO(driver, connectUrl, oId, oPass);
	}

	
	
	
}
