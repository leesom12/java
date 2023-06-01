package common;

import javax.servlet.http.HttpServletRequest;

public class CommonToday implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		String today = CommonUtil.getToday();
		String todayTime = CommonUtil.getTodayTime();
		request.setAttribute("t_today", today);
		request.setAttribute("t_todayTime", todayTime);
	}

}
