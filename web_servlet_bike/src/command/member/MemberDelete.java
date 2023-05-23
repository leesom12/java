package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.MemberDao;

public class MemberDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		String id = request.getParameter("t_id");
		
		MemberDao dao = new MemberDao();
		int result = dao.memberDelete(id);
		
		String msg="";
		
		if(result != 1) {
			msg="탈퇴 실패. 문의 요망";
		}else {
			msg="탈퇴가 완료되었습니다.";
			HttpSession session= request.getSession();
			session.invalidate();
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Index");
		
		
	}

}
