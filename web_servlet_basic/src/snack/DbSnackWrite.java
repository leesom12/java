package snack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SnackDao;
import dto.SnackDto;

/**
 * Servlet implementation class DbSnackWrite
 */
@WebServlet("/DbSnackWrite")
public class DbSnackWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbSnackWrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SnackDao dao= new SnackDao();
		
		String p_code= request.getParameter("t_p_code");
		String p_name= request.getParameter("t_p_name");
		String price= request.getParameter("t_price");
		int price2= Integer.parseInt(price);
		String m_code= request.getParameter("t_m_code");
		
		SnackDto dto= new SnackDto(p_code, p_name, m_code, price2);
		int result= dao.snackSave(dto);
		String msg= "등록 성공";
		String url= "SnackList";
		if(result != 1) {
			msg="등록 실패";
			url= "SnackWrite";
		}
		
		int count= dao.checkPCode(p_code);
		if(count != 0) {
			msg="이미 존재하는 제품 번호입니다. 다시 입력해 주세요!";
			url= "SnackWrite";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		RequestDispatcher rd= request.getRequestDispatcher("common_alert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
