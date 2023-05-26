package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.member.MemberDelete;
import command.member.MemberInfo;
import command.member.MemberJoin;
import command.member.MemberLogin;
import command.member.MemberLogout;
import command.member.MemberPasswordChange;
import command.member.MemberPasswordSend;
import command.member.MemberUpdate;
import common.CommonExecute;

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
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun="memberLogin";
		String viewPage="";
		
		//회원가입 페이지 이동
		if(gubun.equals("memberJoin")) {
			viewPage="member/member_join.jsp";
		}
		//로그인 페이지 이동
		else if(gubun.equals("memberLogin")) {
			viewPage="member/member_login.jsp";
		}
		//회원가입 저장
		else if(gubun.equals("memberSave")) {
			CommonExecute ce = new MemberJoin();
			ce.execute(request);
			viewPage="common_alert.jsp";
		}
		//로그인
		else if(gubun.equals("login")) {
			CommonExecute ce= new MemberLogin();
			ce.execute(request);
			viewPage="common_alert.jsp";
		}
		//로그아웃
		else if(gubun.equals("memberLogout")) {
			CommonExecute ce= new MemberLogout();
			ce.execute(request);
			viewPage="common_alert.jsp";
		}
		//마이 페이지
		else if(gubun.equals("myPage")) {
			CommonExecute ce= new MemberInfo();
			ce.execute(request);
			
			String session = (String)request.getAttribute("t_session");
			
			if(session.equals("null")) {
				viewPage= "common_alert.jsp";
			}else {
				viewPage="member/member_info.jsp";
			}
		}
		//업데이트 폼 이동
		else if(gubun.equals("udpateForm")) {
			CommonExecute ce= new MemberInfo();
			ce.execute(request);
			
			String session = (String)request.getAttribute("t_session");
			
			if(session.equals("null")) {
				viewPage= "common_alert.jsp";
			}else {
				viewPage="member/member_update.jsp";
			}
		}
		//멤버 업데이트
		else if(gubun.equals("memberUpdate")) {
			CommonExecute ce = new MemberUpdate();
			ce.execute(request);
			viewPage="common_alert.jsp";
		}
		//멤버 탈퇴
		else if(gubun.equals("memberDelete")) {
			CommonExecute ce = new MemberDelete();
			ce.execute(request);
			viewPage="common_alert.jsp";
		}
		//비밀번호 찾기 폼 이동
		else if(gubun.equals("memberPasswordFind")) {
			viewPage="member/member_passwordFind.jsp";
		}
		//비밀번호 찾기
		else if(gubun.equals("memberPasswordSend")) {
			CommonExecute ce = new MemberPasswordSend();
			ce.execute(request);
			viewPage="common_alert.jsp";
		}
		//비밀번호 변경폼 이동
		else if(gubun.equals("passwordUpdate")) {
			viewPage="member/member_passwordUpdate.jsp";
		}
		//비밀번호 변경
		else if(gubun.equals("memberPasswordUpdate")) {
			CommonExecute ce = new MemberPasswordChange();
			ce.execute(request);
			viewPage="common_alert.jsp";
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
