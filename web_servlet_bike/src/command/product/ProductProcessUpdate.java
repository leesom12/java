package command.product;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ProductDao;

public class ProductProcessUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String msg="";
		
		String no = request.getParameter("t_no");
		String state = request.getParameter("t_process_state");
		
		int result = dao.processUpdate(no, state);
		if(result == 1) msg="배송상태 수정이 완료되었습니다.";
		else msg="수정에 실패했습니다";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "ProductSale");
		
	}

}
