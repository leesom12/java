package command.etc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.EtcDao;
import dto.EtcDto;

/**
 * Servlet implementation class CommentsList
 */
@WebServlet("/CommentsList")
public class CommentsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		
		EtcDao dao = new EtcDao();
		String no = request.getParameter("t_no");
		EtcDto dto = dao.viewEtc(no);	//원글 조회
		ArrayList<EtcDto> arr = dao.viewEtcComments(no, "=");	//댓글 조회

		JSONObject fobj = new JSONObject();
		
		JSONArray jarr = new JSONArray();
		JSONObject jsub = new JSONObject();
		HashMap<String, Object> hM = new HashMap<String, Object>();
		
		for(int i=0; i<arr.size(); i++) {
			hM = new HashMap<String, Object>();
			String comm_no = arr.get(i).getNo();
			hM.put("no", comm_no);
			String group_no = arr.get(i).getGroup_no();
			hM.put("group_no", group_no);
			int depth = arr.get(i).getDepth();
			hM.put("depth", depth);
			String title = arr.get(i).getTitle();
			hM.put("title", title);
			String content = arr.get(i).getContent();
			hM.put("content", content);
			String reg_id = arr.get(i).getReg_id();
			hM.put("reg_id", reg_id);
			String reg_name = arr.get(i).getReg_name();
			hM.put("reg_name", reg_name);
			String reg_date = arr.get(i).getReg_date();
			hM.put("reg_date", reg_date);
			
			jsub = new JSONObject(hM);
			jarr.add(jsub);
		}
		
		fobj.put("t_arr", jarr);
		out.print(fobj);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
