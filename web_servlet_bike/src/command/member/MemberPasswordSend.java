package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;

public class MemberPasswordSend implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		String mobile_1 = request.getParameter("t_mobile_1");
		String mobile_2 = request.getParameter("t_mobile_2");
		String mobile_3= request.getParameter("t_mobile_3");
		String email = request.getParameter("t_email");
		
		String name = dao.findPassword(id, mobile_1, mobile_2, mobile_3);
		String msg="";
		
		if(name.equals("")) {
			msg="아이디나 전화번호가 정확하지 않습니다.";
		}else {
			msg=name+"님 이메일로 새 비밀번호를 발송했습니다.";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Member");
	}

}
