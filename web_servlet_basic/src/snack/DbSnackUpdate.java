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
 * Servlet implementation class DbSnackUpdate
 */
@WebServlet("/DbSnackUpdate")
public class DbSnackUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbSnackUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SnackDao dao = new SnackDao();
		
		String p_code= request.getParameter("t_p_code");
		String p_name= request.getParameter("t_p_name");
		String price= request.getParameter("t_price");
		price= price.replaceAll(",", "");
		price= price.replaceAll(" ", "");
		int price2= Integer.parseInt(price);
		String m_code= request.getParameter("t_m_code");
		
		SnackDto dto= new SnackDto(p_code, p_name, m_code, price2);
		String msg="수정 성공";
		int result= dao.updateSnack(dto);
		if(result != 1) msg="수정 실패";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "SnackList");
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
