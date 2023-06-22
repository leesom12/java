package command.product;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductDto;

public class ProductSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String msg="";
		String product_dir = CommonUtil.getFile_dir_product();
		int maxSize = 1024*1024*10;
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, product_dir, maxSize, "utf-8", new DefaultFileRenamePolicy());
			String no = dao.getProductNum();
			String p_name= mpr.getParameter("t_title");
			String detail = mpr.getParameter("t_content");
			String p_size = mpr.getParameter("t_size");
			String price1 = mpr.getParameter("t_price");
			price1= price1.replaceAll(",", "");
			price1 = price1.replaceAll(" ", "");
			int price= Integer.parseInt(price1);
			String p_level= mpr.getParameter("t_level");
			String attach = mpr.getFilesystemName("t_attach");
			
			HttpSession session = request.getSession();
			String reg_id = (String) session.getAttribute("sessionId");
			String reg_date = CommonUtil.getTodayTime();
			
			ProductDto dto = new ProductDto(no, p_name, detail, p_size, price, p_level, attach, reg_id, reg_date);
			int result = dao.saveProduct(dto);
			if(result == 1) {
				msg="등록이 완료되었습니다";
			}else {
				msg="등록에 실패했습니다";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Product");
	}

}
