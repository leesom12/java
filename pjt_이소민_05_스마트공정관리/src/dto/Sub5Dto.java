package dto;

public class Sub5Dto {
	private String w_workno, p_code, p_name, p_p1, p_p2, p_p3, w_lastdate, w_lasttime;

	public Sub5Dto(String w_workno, String p_code, String p_name, String p_p1, String p_p2, String p_p3,
			String w_lastdate, String w_lasttime) {
		super();
		this.w_workno = w_workno;
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_p1 = p_p1;
		this.p_p2 = p_p2;
		this.p_p3 = p_p3;
		this.w_lastdate = w_lastdate;
		this.w_lasttime = w_lasttime;
	}

	public String getW_workno() {
		return w_workno;
	}

	public String getP_code() {
		return p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public String getP_p1() {
		return p_p1;
	}

	public String getP_p2() {
		return p_p2;
	}

	public String getP_p3() {
		return p_p3;
	}

	public String getW_lastdate() {
		return w_lastdate;
	}

	public String getW_lasttime() {
		return w_lasttime;
	}
	
	
}
