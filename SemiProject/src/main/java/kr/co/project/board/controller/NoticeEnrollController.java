package kr.co.project.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.board.service.BoardServiceImpl;

@WebServlet("/noticeEnroll.do")
public class NoticeEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		int memberNo = (Integer)session.getAttribute("no");
		
		BoardServiceImpl boardService = new BoardServiceImpl();
		
		int result = boardService.noticeEnroll(title, content, memberNo);
		
		if(result > 0) {
			response.sendRedirect("/NoticeList.do");
		}else {
			response.sendRedirect("/views/common/error.jsp");			
		}
		
		
	}

}