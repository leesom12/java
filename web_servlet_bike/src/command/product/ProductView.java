package command.product;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ProductDao;
import dto.ProductDto;

public class ProductView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String no = request.getParameter("t_no");
		
		dao.updateHit(no);
		ProductDto dto = dao.productView(no);
		ProductDto preDto = dao.getPreDto(no);
		ProductDto nextDto = dao.getNextDto(no);
		
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_predto", preDto);
		request.setAttribute("t_nextdto", nextDto);
	}

}
