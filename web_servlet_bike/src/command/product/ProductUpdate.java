package command.product;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductDto;

public class ProductUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String msg="";
		String productDir = CommonUtil.getFile_dir_product();
		int maxSize = 1024*1024*10;
		MultipartRequest mpr = null;
		
		try {
			mpr = new MultipartRequest(request, productDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String no = mpr.getParameter("t_no");
		String p_name = mpr.getParameter("t_title");
		String detail = mpr.getParameter("t_content");
		String p_size = mpr.getParameter("t_size");
		String strPrice = mpr.getParameter("t_price");
		strPrice = strPrice.replaceAll(",", "");
		strPrice = strPrice.replaceAll(" ", "");
		int price = Integer.parseInt(strPrice);
		String p_level = mpr.getParameter("t_level");
		
		String saveAttach = "";
		String oriAttach = mpr.getParameter("t_oriAttach");
		String newAttach = mpr.getFilesystemName("t_attach");
		if(newAttach != null) {
			File file = new File(productDir, oriAttach);
			boolean tf = file.delete();
			if(!tf) {
				msg="수정 실패";
				System.out.println("ProductUpdate 중 file.delete 오류 발생!!");
			}
			saveAttach = newAttach;
		}else {
			saveAttach = oriAttach;
		}
		
		ProductDto dto = new ProductDto(no, p_name, detail, p_size, p_level, saveAttach, CommonUtil.getTodayTime(), price);
		int result = dao.updateProduct(dto);
		if(result == 1) msg="수정 성공";
		else msg="수정 실패";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Product");
	}

}







