package command.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = new NoticeDao();
		String no = request.getParameter("t_no");
		dao.hitUpdate(no);
		
		NoticeDto dto = dao.noticeView(no);
		NoticeDto preDto = dao.preView(no);
		NoticeDto nextDto= dao.nextView(no);
		
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_preDto", preDto);
		request.setAttribute("t_nextDto", nextDto);
	}

}
