package command.news;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.NewsDao;
import dto.NewsDto;

public class NewsView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NewsDao dao = new NewsDao();
		String no = request.getParameter("t_no");
		dao.hitUpdate(no);
		
		NewsDto dto = dao.newsView(no);
		NewsDto predto = dao.preNo(no);
		NewsDto nextdto = dao.nextNo(no);		
		
		String extension="";
		if(dto.getAttach()!=null) {
			int len = dto.getAttach().indexOf(".");
			extension = dto.getAttach().substring(len+1);
		}
		
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_predto", predto);
		request.setAttribute("t_nextdto", nextdto);
		request.setAttribute("t_extension", extension);
	}

}
