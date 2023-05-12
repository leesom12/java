package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.MemberDelete;
import command.member.MemberList;
import command.member.MemberSave;
import command.member.MemberUpdate;
import command.member.MemberView;
import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

/**
 * Servlet implementation class Member
 */
@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Member() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun= request.getParameter("t_gubun");
		String viewPage="";
		if(gubun == null) gubun="list";
		
		if(gubun.equals("list")) {  //목록
			MemberList memberList = new MemberList();
			memberList.execute(request);
		//	viewPage="member/member_list.jsp";
			viewPage="member/member_list_jstl.jsp";
		}else if(gubun.equals("writeForm")) {  //등록폼으로 이동
			viewPage="member/member_wirte.jsp";
		}else if(gubun.equals("memberSave")) {  //저장
			MemberSave ms = new MemberSave();
			ms.execute(request);
			viewPage="common_alert.jsp";
		}else if(gubun.equals("view")) {  //상세보기
			CommonExecute view= new MemberView();
			view.execute(request);
		//	viewPage="member/member_view.jsp";
			viewPage="member/member_view_jstl.jsp";
		}else if(gubun.equals("updateForm")) {  //수정폼 이동
			CommonExecute view= new MemberView();
			view.execute(request);
		//	viewPage="member/member_update.jsp";
			viewPage="member/member_update_jstl.jsp";
		}else if(gubun.equals("update")) {  //수정 저장
			CommonExecute update= new MemberUpdate();
			update.execute(request);
			viewPage="common_alert.jsp";
		}else if(gubun.equals("delete")) {  //삭제
			CommonExecute delete= new MemberDelete();
			delete.execute(request);
			viewPage= "common_alert.jsp";
		}
		
		RequestDispatcher rd= request.getRequestDispatcher(viewPage);
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
