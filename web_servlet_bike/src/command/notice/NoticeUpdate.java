package command.notice;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = new NoticeDao();
		
		String noticeDir = CommonUtil.getFile_dir_notice();
		int maxSize= 1024*1024*10;
		
		String msg ="";
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, noticeDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
			String no = mpr.getParameter("t_no");
			String title= mpr.getParameter("t_title");
			title = title.replaceAll("\'", "\''");
			String content= mpr.getParameter("t_content");
			content = content.replaceAll("\'", "\''");
			
			String saveAttach = "";
			String attach = mpr.getFilesystemName("t_attach");
			if(attach == null) attach="";
			
			String oriAttach = mpr.getParameter("t_oriAttach");
			if(oriAttach == null) oriAttach="";
			
			String deleteAttach = mpr.getParameter("t_deleteAttach");
			if(deleteAttach != null) {
				File file = new File(noticeDir, oriAttach);
				boolean tf = file.delete();
				if(!tf) System.out.print("notice 첨부파일 삭제 실패: "+tf);
			}else {
				saveAttach = oriAttach;
			}
			
			if(!attach.equals("")) {
				if(!oriAttach.equals("")) {
					File file = new File(noticeDir, oriAttach);
					boolean tf = file.delete();
					if(!tf) System.out.print("notice 첨부파일 삭제 실패: "+tf);
				}
				saveAttach = attach;
			}
			
			NoticeDto dto= new NoticeDto(no, title, content, saveAttach);
			int result= dao.updateNotice(dto);

			if(result == 1) msg="수정이 완료되었습니다.";
			else msg="수정에 실패했습니다.";
			
			
		} catch (IOException e) {
			System.out.println("NoticeUpdate() 오류 발생!!");
			e.printStackTrace();
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Notice");
	}

}









