package command.etc;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.EtcDao;
import dto.EtcDto;

public class EtcUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		EtcDao dao = new EtcDao();
		String no = request.getParameter("t_no");
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		String update_date = CommonUtil.getTodayTime();
		
		EtcDto dto = new EtcDto(no, title, content, update_date);
		int result = dao.updateEtc(dto);
		String msg="";
		if(result == 1)msg="수정 완료";
		else msg="수정 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Etc");
	}

}
