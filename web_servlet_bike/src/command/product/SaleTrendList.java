package command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ProductDao;
import dto.ProductSaleDto;

public class SaleTrendList implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		if(select == null) {
			select = "s.product_no";
			search = "";
		}
		ArrayList<ProductSaleDto> arr = dao.getProductSaleTrend(select, search);
		
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		request.setAttribute("t_arr", arr);
	}

}
