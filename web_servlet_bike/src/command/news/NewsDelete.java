package command.news;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.NewsDao;

public class NewsDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NewsDao dao = new NewsDao();
		String msg="";
		
		String no = request.getParameter("t_no");
		String newsDir = CommonUtil.getFile_dir_news();
		String attach = request.getParameter("t_attach");
		
		File file = new File(newsDir, attach);
		boolean del = file.delete();
		if(!del) {
			msg="삭제 실패!!";
			System.out.println("(NewsDelete) news attach delete 실패 !!");
		}else {
			int result = dao.deleteNews(no);
			if(result == 1) msg="삭제 완료";
			else msg="삭제 실패!!";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "News");
		

	}

}
