package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberJoin implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao= new MemberDao();
		String id= request.getParameter("t_id");
		String name= request.getParameter("t_name");
		String pw= request.getParameter("t_pw");
		int pass_len= pw.length();
		try {
			pw = dao.encryptSHA256(pw); 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		String reg_date= CommonUtil.getTodayTime();
		
		MemberDto dto = new MemberDto(id, name, pw, area, address, mo1, mo2, mo3, gender, travel, reading, sports, reg_date, pass_len);
		
		int result= dao.saveMember(dto);
		String msg= "가입 완료";
		String url= "Member";
		if(result != 1) {
			int count = dao.checkId(id);
			if(count != 0) msg="이미 존재하는 ID입니다. 다시 입력해 주세요";
			else msg="등록 실패!";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		

	}

}
