package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.product.ProductDelete;
import command.product.ProductLIst;
import command.product.ProductSave;
import command.product.ProductUpdate;
import command.product.ProductView;
import common.CommonExecute;
import common.CommonToday;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun="list";
		String viewPage= "";
		
		if(gubun.equals("list")) {
			CommonExecute ce = new ProductLIst();
			ce.execute(request);
			viewPage="product/product_list.jsp";
		}else if(gubun.equals("writeForm")) {
			CommonExecute ce = new CommonToday();
			ce.execute(request);
			viewPage="product/product_write.jsp";
		}else if(gubun.equals("save")) {
			CommonExecute ce= new ProductSave();
			ce.execute(request);
			viewPage="common_alert.jsp";
		}else if(gubun.equals("view")) {
			CommonExecute ce = new ProductView();
			ce.execute(request);
			viewPage  ="product/product_view.jsp";
		}else if(gubun.equals("updateForm")) {
			CommonExecute ce = new ProductView();
			ce.execute(request);
			viewPage = "product/product_update.jsp";
		}else if(gubun.equals("update")) {
			CommonExecute ce = new ProductUpdate();
			ce.execute(request);
			viewPage = "common_alert.jsp";
		}else if(gubun.equals("delete")) {
			CommonExecute ce = new ProductDelete();
			ce.execute(request);
			viewPage = "common_alert.jsp";
		}
		
		RequestDispatcher rd= request.getRequestDispatcher(viewPage);
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
