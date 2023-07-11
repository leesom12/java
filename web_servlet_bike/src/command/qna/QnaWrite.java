package command.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class QnaWrite implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		
		String no = dao.getMaxNo();
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		HttpSession session = request.getSession();
		String reg_id = (String) session.getAttribute("sessionId");
		String reg_date = CommonUtil.getTodayTime();
		
		QnaDto dto = new QnaDto(no, title, content, reg_id, reg_date);
		
		int result = dao.saveQuestion(dto);
		String msg="";
		if(result == 1) msg="질문 등록 완료";
		else msg="등록 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Qna");
		
		
	}

}
