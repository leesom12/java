package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.qna.QnaDelete;
import command.qna.QnaList;
import command.qna.QnaReply;
import command.qna.QnaReplyDelete;
import command.qna.QnaUpdate;
import command.qna.QnaView;
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
		
		//목록
		if(gubun.equals("list")) {
			CommonExecute ce = new QnaList();
			ce.execute(request);
			viewPage = "qna/qna_list.jsp";
		//상세보기
		}else if(gubun.equals("view")) {
			CommonExecute ce = new QnaView();
			ce.execute(request);
			viewPage="qna/qna_view.jsp";
		//질문 폼 이동
		}else if(gubun.equals("writeForm")) {
			CommonExecute ce = new CommonToday();
			ce.execute(request);
			viewPage = "qna/qna_write.jsp";
		//질문등록
		}else if(gubun.equals("write")) {
			CommonExecute ce = new QnaWrite();
			ce.execute(request);
			viewPage = "common_alert.jsp";
		//업데이트 폼 이동
		}else if(gubun.equals("updateForm")) {
			CommonExecute ce = new QnaView();
			ce.execute(request);
			CommonExecute de = new CommonToday();
			de.execute(request);
			viewPage="qna/qna_update.jsp";
		//질문업데이트	
		}else if(gubun.equals("update")) {
			CommonExecute ce = new QnaUpdate();
			ce.execute(request);
			viewPage = "common_alert.jsp";
		//질문삭제	
		}else if(gubun.equals("delete")) {
			CommonExecute ce = new QnaDelete();
			ce.execute(request);
			viewPage = "common_alert.jsp";
		//답변 폼 이동	
		}else if(gubun.equals("replyForm")) {
			CommonExecute ce = new QnaView();
			ce.execute(request);
			CommonExecute de = new CommonToday();
			de.execute(request);
			viewPage="qna/qna_reply.jsp";
		//답변 등록
		}else if(gubun.equals("replySave")) {
			CommonExecute ce = new QnaReply();
			ce.execute(request);
			viewPage = "common_alert.jsp";
		//답변수정 폼 이동
		}else if(gubun.equals("replyUpdateForm")) {
			CommonExecute ce = new QnaView();
			ce.execute(request);
			viewPage="qna/qna_replyUpdate.jsp";
		//답변 수정	
		}else if(gubun.equals("replyUpdate")) {
			CommonExecute ce = new QnaReply();
			ce.execute(request);
			viewPage = "common_alert.jsp";
		//답변 삭제	
		}else if(gubun.equals("replyDelete")) {
			CommonExecute ce = new QnaReplyDelete();
			ce.execute(request);
			viewPage = "common_alert.jsp";
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
