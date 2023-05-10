package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.snack.SnackDelete;
import command.snack.SnackList;
import command.snack.SnackSave;
import command.snack.SnackUpdate;
import command.snack.SnackView;
import common.CommonExecute;

/**
 * Servlet implementation class Snack
 */
@WebServlet("/Snack")
public class Snack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Snack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun ="list";
		String page= "";
		
		if(gubun.equals("list")) {
			CommonExecute ce= new SnackList();
			ce.execute(request);
			page="snack/snack_list.jsp";
		}else if(gubun.equals("write")) {
			page="snack/snack_write.jsp";
		}else if(gubun.equals("save")) {
			CommonExecute ce= new SnackSave();
			ce.execute(request);
			page="common_alert.jsp";
		}else if(gubun.equals("view")) {
			CommonExecute ce= new SnackView();
			ce.execute(request);
			page="snack/snack_view.jsp";
		}else if(gubun.equals("updateForm")) {
			CommonExecute ce= new SnackView();
			ce.execute(request);
			page="snack/snack_update.jsp";
		}else if(gubun.equals("updateSave")) {
			CommonExecute ce= new SnackUpdate();
			ce.execute(request);
			page="common_alert.jsp";
		}else if(gubun.equals("delete")) {
			CommonExecute ce= new SnackDelete();
			ce.execute(request);
			page="common_alert.jsp";
		}
		
		RequestDispatcher rd= request.getRequestDispatcher(page);
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
