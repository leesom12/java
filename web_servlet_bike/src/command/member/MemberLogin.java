package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberLogin implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao= new MemberDao();
		String id= request.getParameter("t_id");
		String pw= request.getParameter("t_pw");
		try {
			pw= dao.encryptSHA256(pw);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MemberDto dto = dao.memberLogin(id, pw);
		String msg="";
		String url="";
		
		if(dto == null) {
			msg="정확하지 않은 아이디 혹은 패스워드입니다";
			url="Member";
		}else {
			msg= dto.getName()+"님 환영합니다!";
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionName", dto.getName());
			session.setAttribute("sessionId", id);
			session.setAttribute("sessionLevel", dto.getLevel());
			
			dao.updateLoginTime(id);
			session.setMaxInactiveInterval(60*60*3);
			url="Index";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		
	}

}
