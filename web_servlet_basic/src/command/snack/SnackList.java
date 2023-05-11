package command.snack;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackList implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao= new SnackDao();
		
		String select = request.getParameter("t_select");
		String search= request.getParameter("t_search");
		if(select == null) {
			select="h.p_code";
			search="";
		}
		String companyRadio= request.getParameter("t_company");
		if(companyRadio == null) companyRadio="";
		
		ArrayList<SnackDto> arr= dao.getSnackList(select, search, companyRadio);
		request.setAttribute("t_arr", arr);
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		
		ArrayList<SnackDto> com = dao.getComapanyList();
		request.setAttribute("t_company", com);
		request.setAttribute("t_companyRadio", companyRadio);

	}

}
