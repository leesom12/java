package command.member;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberInfo implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionId");
		
		String msg="";
		String url="";
		
		if(sessionId == null) {
			msg="로그인 세션이 만료되었습니다. 다시 로그인 해 주세요";
			url="Member";
			request.setAttribute("t_session", "null");
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
		}else {
			MemberDto dto = dao.memberInfo(sessionId);
			request.setAttribute("t_session", "not_null");
			request.setAttribute("t_dto", dto);
		}

	}

}
