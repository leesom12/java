package command.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.NoticeDao;

public class NoticeUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = new NoticeDao();
		
		String noticeDir = CommonUtil.getFile_dir_notice();
		int maxSize= 1024*1024*10;
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, noticeDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
			String no = mpr.getParameter("t_no");
			String title= mpr.getParameter("t_title");
			title = title.replaceAll("\'", "\''");
			String content= mpr.getParameter("t_content");
			content = content.replaceAll("\'", "\''");
			
			String attach = mpr.getFilesystemName("t_attach");
			
		} catch (IOException e) {
			System.out.println("NoticeUpdate() 오류 발생!!");
			e.printStackTrace();
		}
	}

}
