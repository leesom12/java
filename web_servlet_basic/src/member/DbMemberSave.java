package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.MemberDto;

/**
 * Servlet implementation class DbMemberSave
 */
@WebServlet("/DbMemberSave")
public class DbMemberSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbMemberSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDao dao= new MemberDao();
		
		String id= request.getParameter("t_id");
		String name= request.getParameter("t_name");
		String age1= request.getParameter("t_age");
		int age= Integer.parseInt(age1);
		String reg_date= request.getParameter("t_reg_date");
		
		MemberDto dto= new MemberDto(id, name, age, reg_date);
		int result= dao.memberSave(dto);
		
		String msg= "등록 성공";
		String url= "MemberList";
		if(result != 1) {
			msg="등록 실패!";
			url="MemberWrite";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		RequestDispatcher rd= request.getRequestDispatcher("common_alert.jsp");
		rd.forward(request, response);
		
//		response.sendRedirect("MemberList");				//servlet에서 다른 servlet 실행

/*
		ArrayList<MemberDto> arr = dao.memberList("id", "");
		request.setAttribute("t_arr", arr);
		request.setAttribute("t_select", "id");
		request.setAttribute("t_search", "");
		
		RequestDispatcher rd= request.getRequestDispatcher("member/member_list.jsp");
		rd.forward(request, response);
*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
