package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao= new MemberDao();
		
		String id= request.getParameter("t_id");
		String name= request.getParameter("t_name");
		String age1= request.getParameter("t_age");
		int age= Integer.parseInt(age1);
		String reg_date= request.getParameter("t_reg_date");
		
		MemberDto dto= new MemberDto(id, name, age, reg_date);
		int result= dao.memberUpadate(dto);
		String msg="수정 성공";
		if(result != 1) msg="수정 실패!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Member");

	}

}
