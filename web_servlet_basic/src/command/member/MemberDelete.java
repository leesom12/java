package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;

public class MemberDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		
		String id= request.getParameter("t_id");
		int result= dao.memberDelete(id);
		String msg="삭제 성공";
		if(result != 1) msg="삭제 실패!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Member");
	}

}
