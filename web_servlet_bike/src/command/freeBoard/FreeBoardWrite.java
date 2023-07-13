package command.freeBoard;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.FreeBoardDao;
import dto.FreeBoardDto;

public class FreeBoardWrite implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeBoardDao dao = new FreeBoardDao();
		HttpSession session = request.getSession();
		MultipartRequest mpr = null;
		
		String freeBord_dir = CommonUtil.getFile_dir_freeBoard();
		int maxSize = 1024*1024*10;
		
		try {
			mpr = new MultipartRequest(request, freeBord_dir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String no = dao.getMaxNo();
		String title = mpr.getParameter("t_title");
		title = title.replaceAll("\'", "\''");
		String content= mpr.getParameter("t_content");
		content = content.replaceAll("\'", "\''");
		String attach = mpr.getFilesystemName("t_attach");
		if(attach==null) attach="";
		String reg_id = (String)session.getAttribute("sessionId");
		String reg_date = CommonUtil.getTodayTime();
		
		FreeBoardDto dto = new FreeBoardDto(no, title, content, attach, reg_id, reg_date);
		int result = dao.saveFreeBoard(dto);
		String msg = "";
		if(result == 1) msg="등록 완료";
		else msg="등록 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "FreeBoard");

	}

}
