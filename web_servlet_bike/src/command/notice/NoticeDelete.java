package command.notice;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.NoticeDao;

public class NoticeDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = new NoticeDao();
		
		String no = request.getParameter("t_no");
		String attach = request.getParameter("t_attach");
		
		String msg="";
		
		int result = dao.noticeDelte(no);
		if(result != 1) {
			msg="삭제 실패!!";
		}else {
			if(!attach.equals("")) {
				File file = new File(CommonUtil.getFile_dir_notice(), attach);
				boolean tf = file.delete();
				if(!tf) System.out.println("notice attach delete 오류 발생: "+tf);
				else msg="삭제 성공";
			}
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Notice");

	}

}
