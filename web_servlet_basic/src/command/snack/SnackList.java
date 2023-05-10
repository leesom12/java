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
			select="h.p_name";
			search="";
		}
		
		ArrayList<SnackDto> arr= dao.getSnackList(select, search);
		request.setAttribute("t_arr", arr);
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);

	}

}
