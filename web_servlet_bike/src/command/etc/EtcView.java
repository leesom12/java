package command.etc;

import javax.servlet.http.HttpServletRequest;
import common.CommonExecute;
import dao.EtcDao;
import dto.EtcDto;

public class EtcView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		EtcDao dao = new EtcDao();
		String no = request.getParameter("t_no");
		EtcDto dto = dao.viewEtc(no);	//원글 조회

		EtcDto preDto = dao.preNo(no);
		EtcDto nextDto = dao.nextNo(no);
		
		request.setAttribute("t_dto", dto);

		request.setAttribute("t_preDto", preDto);
		request.setAttribute("t_nextDto", nextDto);
		

		

		
	}

}
