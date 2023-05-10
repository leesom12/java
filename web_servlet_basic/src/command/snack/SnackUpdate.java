package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		SnackDao dao = new SnackDao();
		
		String p_code= request.getParameter("t_p_code");
		String p_name= request.getParameter("t_p_name");
		String price= request.getParameter("t_price");
		price= price.replaceAll(",", "");
		price= price.replaceAll(" ", "");
		int price2= Integer.parseInt(price);
		String m_code= request.getParameter("t_m_code");
		
		SnackDto dto= new SnackDto(p_code, p_name, m_code, price2);
		String msg="수정 성공";
		int result= dao.updateSnack(dto);
		if(result != 1) msg="수정 실패";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Snack");
	}

}
