package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.product.ProductOrderDelete;
import command.product.ProductProcessUpdate;
import command.product.ProductSaleList;
import command.product.ProductSaleView;
import common.CommonExecute;

/**
 * Servlet implementation class ProductSale
 */
@WebServlet("/ProductSale")
public class ProductSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun="saleList";
		String viewPage= "";
		
		//주문하기
		if(gubun.equals("sale")) {
			CommonExecute ce = new command.product.ProductSale();
			ce.execute(request);
			viewPage="common_alert.jsp";
		//판매리스트
		}else if(gubun.equals("saleList")) {
			CommonExecute ce = new ProductSaleList();
			ce.execute(request);
			viewPage="product/product_sale_list.jsp";
		//판매내역 뷰
		}else if(gubun.equals("saleView")) {
			CommonExecute ce = new ProductSaleView();
			ce.execute(request);
			viewPage = "product/product_sale_view.jsp";
		//판매상태 변경
		}else if(gubun.equals("saleProcessUpdate")) {
			CommonExecute ce = new ProductProcessUpdate();
			ce.execute(request);
			viewPage="common_alert.jsp";
		}
		//회원구매내역 상세보기
		else if(gubun.equals("orderView")) {
			CommonExecute ce = new ProductSaleView();
			ce.execute(request);
			viewPage="member/order_view.jsp";
		}
		//회원 주문 취소
		else if(gubun.equals("orderDelete")) {
			CommonExecute ce = new ProductOrderDelete();
			ce.execute(request);
			
			viewPage="common_alert.jsp";
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
