package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.qna.QnaList;
import command.qna.QnaWrite;
import common.CommonExecute;
import common.CommonToday;

/**
 * Servlet implementation class Qna
 */
@WebServlet("/Qna")
public class Qna extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qna() {
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
		String viewPage = "";
		
		request.setAttribute("nowPage", "qna");
		
		if(gubun.equals("list")) {
			CommonExecute ce = new QnaList();
			ce.execute(request);
			viewPage = "qna/qna_list.jsp";
		}else if(gubun.equals("view")) {
			
		}else if(gubun.equals("writeForm")) {
			CommonExecute ce = new CommonToday();
			ce.execute(request);
			viewPage = "qna/qna_write.jsp";
		}else if(gubun.equals("write")) {
			CommonExecute ce = new QnaWrite();
			ce.execute(request);
			viewPage = "common_alert.jsp";
		}else if(gubun.equals("updateForm")) {
			
		}else if(gubun.equals("update")) {
			
		}else if(gubun.equals("delete")) {
			
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
