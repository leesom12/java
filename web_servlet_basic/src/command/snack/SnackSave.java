package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao= new SnackDao();
		
		String p_code= request.getParameter("t_p_code");
		String p_name= request.getParameter("t_p_name");
		String price= request.getParameter("t_price");
		int price2= Integer.parseInt(price);
		String m_code= request.getParameter("t_m_code");
		
		SnackDto dto= new SnackDto(p_code, p_name, m_code, price2);

		String msg= "";
		String url= "Snack";
		
		int count= dao.checkPCode(p_code);
		if(count != 0) {
			msg="이미 존재하는 코드. 다른 번호로 입력하세요!";
		}else {
			int result= dao.snackSave(dto);
			if(result != 1) {
				msg="등록 실패";
			}else {
				msg="등록 성공";
			}
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);

	}

}
