package command.freeBoard;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.FreeBoardDao;

public class FreeBoardDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeBoardDao dao = new FreeBoardDao();
		
		String no = request.getParameter("t_no");
		String attach = request.getParameter("t_attach");
		
		String msg="";
		
		int result = dao.deleteFreeBoard(no);
		if(result != 1) {
			msg="삭제 실패!!";
		}else {
			if(!attach.equals("")) {
				File file = new File(CommonUtil.getFile_dir_freeBoard(), attach);
				boolean tf = file.delete();
				if(!tf) {
					System.out.println("FreeBoardDelete 파일삭제 중 오류 발생: "+tf);
					msg="삭제 실패";
				}else {
					msg="삭제 성공";
				}
			}else {
				msg="삭제 성공";
			}
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "FreeBoard");

	}

}
