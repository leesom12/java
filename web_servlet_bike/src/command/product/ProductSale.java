package command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductSaleDto;

public class ProductSale implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String msg="";
		String url="";
		
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionId");
		if(sessionId == null) {
			msg="로그인 후 주문해 주세요";
			url="Member";
		}else {
			String no = dao.getProductSaleNo();
			String product_no = request.getParameter("t_no");
			String address = request.getParameter("t_address");
			String payment = request.getParameter("t_payment");
			String price1 = request.getParameter("t_price");
			int price = Integer.parseInt(price1);
			
			String process_state="";
			if(payment.equals("card")) {
				process_state="배송중";
				payment="카드";
			}
			else if(payment.equals("cash")) {
				process_state="입금확인중";
				payment="무통장입금";
			}
			
			String purchase_date = CommonUtil.getTodayTime();
			String mem_id = sessionId;
			
			ProductSaleDto dto = new ProductSaleDto(no, product_no, mem_id, address, payment, process_state, purchase_date, price);
			int result = dao.saveProductSale(dto);
			if(result == 1) {
				msg="주문이 완료되었습니다!";
				url="Product";
			}else {
				msg="오류 발생!!";
				url="Product";
			}
		}

		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		
	}

}
