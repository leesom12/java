package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.product.ProductLIst;
import common.CommonExecute;
import dao.NoticeDao;
import dao.ProductDao;
import dto.NoticeDto;
import dto.ProductDto;

/**
 * Servlet implementation class index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDao n_dao = new NoticeDao();
		ProductDao p_dao = new ProductDao();
		
		ArrayList<NoticeDto> n_arr = n_dao.noticeListPage("n.no", "", 1, 7);
		ArrayList<ProductDto> p_arr = p_dao.getProductList("no", "", 1, 6);

		request.setAttribute("n_arr", n_arr);
		request.setAttribute("p_arr", p_arr);
		
		RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
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
