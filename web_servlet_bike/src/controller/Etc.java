package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.etc.EtcList;
import command.etc.EtcView;
import command.etc.EtcWrite;
import common.CommonExecute;
import common.CommonToday;

/**
 * Servlet implementation class Etc
 */
@WebServlet("/Etc")
public class Etc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Etc() {
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
		request.setAttribute("nowPage", "etc");
		
		//리스트
		if(gubun.equals("list")) {
			CommonExecute ce = new EtcList();
			ce.execute(request);
			viewPage="etc/etc_list.jsp";
		//원글 작성 폼
		}else if(gubun.equals("writeForm")) {
			CommonExecute ce = new CommonToday();
			ce.execute(request);
			viewPage="etc/etc_write.jsp";
		//원글 작성	
		}else if(gubun.equals("write")) {
			CommonExecute ce = new EtcWrite();
			ce.execute(request);
			viewPage="common_alert.jsp";
		//뷰	
		}else if(gubun.equals("view")) {
			CommonExecute ce = new EtcView();
			ce.execute(request);
			viewPage="etc/etc_view.jsp";
		//댓글 작성	
		}else if(gubun.equals("commentWrite")) {
			
		//수정 폼	
		}else if(gubun.equals("updateForm")) {
			viewPage="etc/etc_update.jsp";
		//수정
		}else if(gubun.equals("update")) {
			
		//삭제
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
