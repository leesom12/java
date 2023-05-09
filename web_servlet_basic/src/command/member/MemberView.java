package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberView implements CommonExecute {

	public void execute(HttpServletRequest request) {
		MemberDao dao= new MemberDao();
		String id= request.getParameter("t_id");
		
		MemberDto dto= dao.memberView(id);
		request.setAttribute("t_dto", dto);
	}

}
