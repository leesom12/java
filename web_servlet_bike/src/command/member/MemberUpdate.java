package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao= new MemberDao();
		String id= request.getParameter("t_id");
		String name= request.getParameter("t_name");
		
		String area= request.getParameter("t_area");
		String address= request.getParameter("t_address");
		String mo1= request.getParameter("t_mobile_1");
		String mo2= request.getParameter("t_mobile_2");
		String mo3= request.getParameter("t_mobile_3");
		String gender= request.getParameter("t_gender");
		String travel= request.getParameter("t_travel");
		String reading= request.getParameter("t_reading");
		String sports= request.getParameter("t_sports");
		if(travel != null) {
			travel="Y";
		}else travel="N";
		if(reading != null) {
			reading="Y";
		}else reading="N";
		if(sports != null) {
			sports="Y";
		}else sports="N";
		String update_date= CommonUtil.getTodayTime();
		
		MemberDto dto= new MemberDto(id, name, area, address, mo1, mo2, mo3, gender, travel, reading, sports, update_date);
		
		int result= dao.memberUpdate(dto);
		String msg="";
		
		if(result == 1) {
			msg="수정이 완료되었습니다";
		}else {
			msg="수정 오류!!";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Index");
		
	}

}
