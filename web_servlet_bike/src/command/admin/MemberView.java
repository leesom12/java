package command.admin;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.AdminDao;
import dto.AdminDto;

public class MemberView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		AdminDao dao = new AdminDao();
		String id = request.getParameter("t_id");
		
		AdminDto dto = dao.getMemberView(id);
		request.setAttribute("t_dto", dto);
	}

}
