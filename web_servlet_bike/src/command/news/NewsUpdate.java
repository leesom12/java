package command.news;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.NewsDao;
import dto.NewsDto;

public class NewsUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NewsDao dao = new NewsDao();
		String newsDir = CommonUtil.getFile_dir_news();
		int maxSize= 1024*1024*10;
		String msg="";
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, newsDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
			
			String no = mpr.getParameter("t_no");
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			
			String saveAttach="";
			String oriAttach = mpr.getParameter("t_oriAttach");
			String attach= mpr.getFilesystemName("t_attach");
			
			if(attach != null) {
				File file = new File(newsDir, oriAttach);
				boolean tf= file.delete();
				if(!tf) System.out.println("(NewsUpdate) news attach delete 실패");
				saveAttach = attach;
			}else {
				saveAttach = oriAttach;
			}
			
			String reg_id= mpr.getParameter("t_regId");
			String reg_date= mpr.getParameter("t_regDate");
			String update_date= CommonUtil.getTodayTime();
			
			NewsDto dto = new NewsDto(no, title, content, saveAttach, reg_id, reg_date, update_date);
			int result = dao.updateNews(dto);
			if(result == 1) msg="수정 성공";
			else msg="수정 실패!!";
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "News");
	}

}



















