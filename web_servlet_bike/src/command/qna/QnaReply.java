package command.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class QnaReply implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		String no = request.getParameter("t_no");
		String reply = request.getParameter("t_reply");
		HttpSession session = request.getSession();
		String reply_id = (String)session.getAttribute("sessionId");
		String reply_name = (String)session.getAttribute("sessionName");
		String reply_date = CommonUtil.getTodayTime();
		String state = "답변완료";
		
		QnaDto dto = new QnaDto(no, reply, reply_date, state, reply_id, reply_name);
		int result = dao.replyQna(dto);
		String msg ="";
		if(result == 1) msg="답변 완료";
		else msg="등록 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Qna");
		
	}

}
