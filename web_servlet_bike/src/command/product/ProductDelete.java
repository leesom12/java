package command.product;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductDao;

public class ProductDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String no = request.getParameter("t_no");
		String attach = request.getParameter("t_attach");
		String msg="";
		
		int result = dao.deleteProduct(no);
		if(result == 1) {
			File file = new File(CommonUtil.getFile_dir_product(), attach);
			boolean tf = file.delete();
			if(!tf) msg="삭제 실패";
			else msg="삭제 성공";
		}else {
			msg="삭제 실패";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Product");
	}

}
