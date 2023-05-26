package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.MemberDao;

public class MemberDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		HttpSession session= request.getSession();
		String id = (String)session.getAttribute("sessionId");
		String name = (String)session.getAttribute("sessionName");
		
		String msg="";
		
		if(id == null) {
			msg="세션이 만료되었습니다. 다시 로그인 해 주세요";
		}else {
			MemberDao dao = new MemberDao();
			int result = dao.memberDelete(id);
			
			if(result == 1) {
				msg= name+"님 탈퇴가 완료되었습니다.";
				session.invalidate();
			}else {
				msg="탈퇴 실패. 문의 요망";
			}
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Index");
		
	}

}
