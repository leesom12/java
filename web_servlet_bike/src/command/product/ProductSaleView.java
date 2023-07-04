package command.product;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ProductDao;
import dto.ProductSaleDto;

public class ProductSaleView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String no = request.getParameter("t_no");
		ProductSaleDto dto = dao.viewSaleList(no);
		request.setAttribute("t_dto", dto);
	}

}
