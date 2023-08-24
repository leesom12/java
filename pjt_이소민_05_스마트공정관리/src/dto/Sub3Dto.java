package dto;

public class Sub3Dto {
	private String w_workno, p_code, p_name, p_size_code, w_quentity, w_workdate;

	//select box
	public Sub3Dto(String p_code, String p_name, String p_size_code) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_size_code = p_size_code;
	}
	
	//save
	public Sub3Dto(String w_workno, String p_code, String w_quentity, String w_workdate) {
		super();
		this.w_workno = w_workno;
		this.p_code = p_code;
		this.w_quentity = w_quentity;
		this.w_workdate = w_workdate;
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

	public String getP_size_code() {
		return p_size_code;
	}

	public String getW_quentity() {
		return w_quentity;
	}

	public String getW_workdate() {
		return w_workdate;
	}
	
	
}
