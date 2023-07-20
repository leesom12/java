package command.etc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonUtil;
import dao.EtcDao;
import dto.EtcDto;

/**
 * Servlet implementation class EtcComment
 */
@WebServlet("/EtcComment")
public class EtcComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtcComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		EtcDao dao = new EtcDao();
		
		String no = dao.getMaxNo();
		String group_no = request.getParameter("t_no");
		String title = request.getParameter("t_comment");
		String content= "";
		HttpSession session = request.getSession();
		String reg_id = (String)session.getAttribute("sessionId");
		String reg_date = CommonUtil.getTodayTime();
		String depth_s = request.getParameter("t_depth");
		int depth = Integer.parseInt(depth_s)+1;
		
		EtcDto dto = new EtcDto(no, group_no, title, content, reg_id, reg_date, depth);
		int result = dao.saveEtc(dto);
		String msg="";
		if(result == 1) msg="등록 완료";
		else msg="등록 실패";
		PrintWriter out = response.getWriter();
		out.print(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
