package command.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeList implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = new NoticeDao();
		String select= request.getParameter("t_select");
		String search= request.getParameter("t_search");
		if(select == null) {
			select = "n.title";
			search="";
		}
	//	ArrayList<NoticeDto> arr = dao.noticeListPage(select, search, start, end);

		
	}

}
