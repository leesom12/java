package command.freeBoard;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.FreeBoardDao;
import dto.FreeBoardDto;

public class FreeBoardView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeBoardDao dao = new FreeBoardDao();
		
		String no = request.getParameter("t_no");
		dao.hitUpdate(no);
		
		FreeBoardDto dto = dao.viewFreeBoard(no);
		FreeBoardDto preDto = dao.preNo(no);
		FreeBoardDto nextDto = dao.nextNo(no);
		
		String extension="";
		if(dto.getAttach()!=null) {
			int len = dto.getAttach().indexOf(".");
			extension = dto.getAttach().substring(len+1);
		}
		
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_preDto", preDto);
		request.setAttribute("t_nextDto", nextDto);
		request.setAttribute("t_extension", extension);

	}

}
