package command.etc;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.EtcDao;

public class EtcDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		EtcDao dao = new EtcDao();
		String no = request.getParameter("t_no");
		int result = dao.deleteEtc(no);
		String msg = "삭제 완료";
		if(result != 1) msg="삭제 실패!!";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Etc");
	}

}
