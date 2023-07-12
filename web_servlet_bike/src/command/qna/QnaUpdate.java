package command.qna;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class QnaUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		String no = request.getParameter("t_no");
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		String update_date = CommonUtil.getTodayTime();

		QnaDto dto = new QnaDto(no, title, content, update_date);
		int result = dao.updateQuestion(dto);
		String msg = "";
		if(result==1) msg ="수정 완료";
		else msg ="수정 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Qna");
	}

}
