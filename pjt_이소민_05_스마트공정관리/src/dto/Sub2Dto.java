package dto;

public class Sub2Dto {
	private String w_workno, p_code, p_name, p_size, p_type, w_workdate;
	private int w_quentity;
	
	public Sub2Dto(String w_workno, String p_code, String p_name, String p_size, String p_type, String w_workdate,
			int w_quentity) {
		super();
		this.w_workno = w_workno;
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_size = p_size;
		this.p_type = p_type;
		this.w_workdate = w_workdate;
		this.w_quentity = w_quentity;
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
	public String getP_size() {
		return p_size;
	}
	public String getP_type() {
		return p_type;
	}
	public String getW_workdate() {
		return w_workdate;
	}
	public int getW_quentity() {
		return w_quentity;
	}
	
	
}
