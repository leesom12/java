package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.freeBoard.FreeBoardDelete;
import command.freeBoard.FreeBoardList;
import command.freeBoard.FreeBoardUpdate;
import command.freeBoard.FreeBoardView;
import command.freeBoard.FreeBoardWrite;
import common.CommonExecute;
import common.CommonToday;

/**
 * Servlet implementation class FreeBoard
 */
@WebServlet("/FreeBoard")
public class FreeBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun = "list";
		String viewPage="";
		request.setAttribute("nowPage", "freeboard");
		
		//목록
		if(gubun.equals("list")) {
			CommonExecute ce = new FreeBoardList();
			ce.execute(request);
			viewPage = "freeBoard/freeBoard_list.jsp";
		//등록 폼
		}else if(gubun.equals("writeForm")) {
			CommonExecute ce = new CommonToday();
			ce.execute(request);
			viewPage = "freeBoard/freeBoard_write.jsp";
		//등록
		}else if(gubun.equals("write")) {
			CommonExecute ce = new FreeBoardWrite();
			ce.execute(request);
			viewPage="common_alert.jsp";
		//상세보기
		}else if(gubun.equals("view")) {
			CommonExecute ce = new FreeBoardView();
			ce.execute(request);
			viewPage = "freeBoard/freeBoard_view.jsp";
		//업데이트 폼
		}else if(gubun.equals("updateForm")) {
			CommonExecute ce = new FreeBoardView();
			ce.execute(request);
			CommonExecute ce2 = new CommonToday();
			ce2.execute(request);
			viewPage = "freeBoard/freeBoard_update.jsp";
		//업데이트
		}else if(gubun.equals("update")) {
			CommonExecute ce = new FreeBoardUpdate();
			ce.execute(request);
			viewPage="common_alert.jsp";
		//삭제
		}else if(gubun.equals("delete")) {
			CommonExecute ce = new FreeBoardDelete();
			ce.execute(request);
			viewPage="common_alert.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
