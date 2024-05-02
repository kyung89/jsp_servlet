package model2.mvcboard;

import java.io.IOException;

import fileUpload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.JSFunction;

@WebServlet("/mvcboard/pass.do")
public class PassController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("mode", req.getParameter("mode"));
		req.getRequestDispatcher("/14MVCBoard/Pass.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idx = req.getParameter("idx");
		String mode = req.getParameter("mode");
		String pass = req.getParameter("pass");
		
		MVCBoardDAO dao = new MVCBoardDAO();
		boolean confirmed = dao.confirmPassword(pass, idx);
		dao.close();
		
		if (confirmed) {
			if (mode.equals("edit")) {
				HttpSession session = req.getSession();
				session.setAttribute("pass", pass);
				resp.sendRedirect("../mvcboard/edit.do?idx=" + idx);
			} else if (mode.equals("delete")) {
				dao = new MVCBoardDAO();
				MVCBoardDTO dto = dao.selectView(idx);
				int result = dao.deletePost(idx);
				dao.close();
				if (result == 1) {
					String saveFileName = dto.getSfile();
					FileUtil.deleteFile(req, "/Uploads2", saveFileName);
				}
				JSFunction.alertLocation(resp, "삭제되었습니다.", "../mvcboard/list.do");
			}
		} else {
			JSFunction.alertBack(resp, "비밀번호 검증에 실패했습니다.");
		}
	}

	
}
