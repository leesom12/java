package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;

public class MemberLogout implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionName= (String)session.getAttribute("sessionName");
		if(sessionName == null){
			sessionName="";
		}else{
			sessionName= sessionName+"님";
		}
		session.invalidate();		// session.invalidate(); 세션 변수값을 모두 없앰
		
		String msg= sessionName+" 로그아웃 되었습니다";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Index");
	}

}
