package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberPasswordChange implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		HttpSession session = request.getSession();
		String id= (String)session.getAttribute("sessionId");
		
		String msg="";
		
		if(id == null) {
			msg="로그인 정보가 만료되었습니다";
		}else {
			String now_pw= request.getParameter("t_now_pw");
			String new_pw= request.getParameter("t_pw");
			int pass_length = new_pw.length();
			
			try {
				now_pw = dao.encryptSHA256(now_pw);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				new_pw = dao.encryptSHA256(new_pw);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MemberDto dto = dao.memberLogin(id, now_pw);
			
			if(dto == null) {
				msg="현재 비밀번호가 맞지 않습니다";
			}else {
				int result = dao.setMemberPassword(id, new_pw, pass_length);
				if(result == 1) {
					msg= dto.getName()+"님 비밀번호 수정이 완료되었습니다";
					session.invalidate();
				}
				else msg="수정 실패! 관리자에게 문의 바랍니다";
			}
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Member");

	}

}
