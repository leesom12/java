package command.etc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.EtcDao;
import dto.EtcDto;

public class EtcCommentWrite implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		EtcDao dao = new EtcDao();
		
		String no = dao.getMaxNo();
		String group_no = request.getParameter("t_no");
		String title = request.getParameter("t_comment");
		String content= "";
		HttpSession session = request.getSession();
		String reg_id = (String)session.getAttribute("sessionId");
		String reg_date = CommonUtil.getTodayTime();
		String depth_s = request.getParameter("t_depth");
		int depth = Integer.parseInt(depth_s)+1;
		
		EtcDto dto = new EtcDto(no, group_no, title, content, reg_id, reg_date, depth);
		int result = dao.saveEtc(dto);
		String msg="";
		if(result == 1) msg="등록 완료";
		else msg="등록 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Etc");
		
	}

}
