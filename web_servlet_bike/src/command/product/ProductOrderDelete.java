package command.product;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ProductDao;

public class ProductOrderDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String no = request.getParameter("t_no");
		int result = dao.orderDelete(no);
		String msg="";
		
		if(result == 1) msg="주문이 취소되었습니다.";
		else msg="취소 실패";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Member?t_gubun=orderDetails");
	}

}
