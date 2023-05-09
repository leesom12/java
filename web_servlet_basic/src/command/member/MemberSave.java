package command.member;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import dao.MemberDao;
import dto.MemberDto;

public class MemberSave {
	public void execute(HttpServletRequest request) {
		MemberDao dao= new MemberDao();
		
		String id= request.getParameter("t_id");
		String name= request.getParameter("t_name");
		String age1= request.getParameter("t_age");
		int age= Integer.parseInt(age1);
		String reg_date= request.getParameter("t_reg_date");
		
		MemberDto dto= new MemberDto(id, name, age, reg_date);
		int result= dao.memberSave(dto);
		
		String msg= "등록 성공";
		String url= "Member";
		if(result != 1) {
			msg="등록 실패!";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
	}
}
