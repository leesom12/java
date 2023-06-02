package command.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeWrite implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = new NoticeDao();
		String noticeDir= CommonUtil.getFile_dir_notice();
		int maxSize= 1024*1024*10;
		String msg ="";
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, noticeDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
			// MultipartRequest(request, 첨부파일 저장경로, 최대 사이즈, 한글깨지지마, 같은 파일이 여러개 올라오면 파일명 리네임)
			// enctype을 지정하면 reqeust.getParameter가 아니라 mpr.getParameter로 받아야함
			//input type이 file일 경우 mpr.getFilesystemName으로 받아옴
			
			
			String no = dao.getMaxNo();
			String title = mpr.getParameter("t_title");
			title = title.replaceAll("\'", "\''");
			String content = mpr.getParameter("t_content");
			content = content.replaceAll("\'", "\''");
			String attach = mpr.getFilesystemName("t_attach");
			if(attach==null) attach="";
			
			HttpSession session = request.getSession();
			String reg_id = (String) session.getAttribute("sessionId");
			String reg_date= CommonUtil.getTodayTime();
			
			NoticeDto dto= new NoticeDto(no, title, content, attach, reg_id, reg_date);
			int result= dao.saveNotice(dto);
			
			if(result == 1) msg="등록이 완료되었습니다.";
			else msg="등록에 실패했습니다.";
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("NoticeWrite 오류 발생!!");
			e.printStackTrace();
			
		}

		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Notice");
		
		
		
		
	}

}
