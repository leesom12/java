package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		SnackDao dao= new SnackDao();
		
		String p_code= request.getParameter("t_p_code");
		SnackDto dto= dao.snackSearch(p_code);
		
		request.setAttribute("t_dto", dto);
	}

}
