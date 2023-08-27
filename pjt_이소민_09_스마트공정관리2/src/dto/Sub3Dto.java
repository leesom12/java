package dto;

public class Sub3Dto {
	private String p_code, p_name, w_workno, w_quentity, w_workdate;

	public Sub3Dto(String p_code, String p_name) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
	}
	

	public Sub3Dto(String p_code, String w_workno, String w_quentity, String w_workdate) {
		super();
		this.p_code = p_code;
		this.w_workno = w_workno;
		this.w_quentity = w_quentity;
		this.w_workdate = w_workdate;
	}


	public String getP_code() {
		return p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public String getW_workno() {
		return w_workno;
	}

	public String getW_quentity() {
		return w_quentity;
	}

	public String getW_workdate() {
		return w_workdate;
	}
	
	
}
