package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;

public class SnackDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		SnackDao dao = new SnackDao();
		
		String p_code= request.getParameter("t_p_code");
		int result = dao.deleteSnack(p_code);
		
		String msg= "삭제 성공";
		if(result != 1) msg="삭제 실패";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Snack");
	}

}
