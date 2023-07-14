package command.freeBoard;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.FreeBoardDao;
import dto.FreeBoardDto;

public class FreeBoardUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeBoardDao dao = new FreeBoardDao();
		
		String freeBoard_dir = CommonUtil.getFile_dir_freeBoard();
		int maxSize = 1024*1024*10;
		
		MultipartRequest mpr = null;
		try {
			mpr= new MultipartRequest(request, freeBoard_dir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String no = mpr.getParameter("t_no");
		String title = mpr.getParameter("t_title");
		title = title.replaceAll("\'", "\''");
		String content= mpr.getParameter("t_content");
		content = content.replaceAll("\'", "\''");
		String update_date = CommonUtil.getTodayTime();
		String download = mpr.getParameter("t_downloadHit");
		int download_hit = Integer.parseInt(download);
		
		String saveAttach = "";
		String attach = mpr.getFilesystemName("t_attach");
		if(attach == null) attach="";
		String oriAttach = mpr.getParameter("t_oriAttach");
		if(oriAttach == null) oriAttach="";
		
		String deleteAttach = mpr.getParameter("t_deleteAttach");
		if(deleteAttach != null) {
			File file = new File(freeBoard_dir, oriAttach);
			boolean tf = file.delete();
			if(!tf) System.out.print("freeboard update 첨부파일 삭제 실패: "+tf);
		}else {
			saveAttach = oriAttach;
		}
		
		if(!attach.equals("")) {
			if(!oriAttach.equals("")) {
				File file = new File(freeBoard_dir, oriAttach);
				boolean tf = file.delete();
				if(!tf) System.out.print("freeboard update2 첨부파일 삭제 실패: "+tf);
				
				if(attach != oriAttach) {
					download_hit = 0;
				}
			}
			saveAttach = attach;
		}
		
		FreeBoardDto dto = new FreeBoardDto(no, title, content, saveAttach, update_date, download_hit);
		int result = dao.updateFreeBoard(dto);
		String msg = "";
		if(result == 1) msg="수정 완료";
		else msg="수정 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "FreeBoard");

	}

}
