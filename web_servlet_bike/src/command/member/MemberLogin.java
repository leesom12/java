package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.MemberDao;

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
		
		String name= dao.memberLogin(id, pw);
		String msg="";
		String url="";
		
		if(name.equals("")) {
			msg="존재하지 않는 정보입니다. ID, PASSWORD 확인하세요";
			url="Member";
		}else {
			msg=name+"님 환영합니다!";
			HttpSession session = request.getSession();
			session.setAttribute("sessionName", name);
			session.setAttribute("sessionId", id);
			dao.updateLoginTime(id);
			session.setMaxInactiveInterval(60*60);
			url="Index";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		
	}

}
