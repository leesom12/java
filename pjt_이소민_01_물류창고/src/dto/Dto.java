package dto;

public class Dto {
	private String p_code, p_name, p_size, c_code, c_name, c_tel, t_no, t_type, t_date, p_incost, p_outcost, t_profit;
	private int t_cnt;
	
	//매출이익 조회
	public Dto(String p_code, String p_name, String t_profit, int t_cnt) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.t_profit = t_profit;
		this.t_cnt = t_cnt;
	}

	
	
	//입출고 조회
	public Dto(String p_code, String p_name, String c_name, String t_no, String t_type, String t_date, int t_cnt) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.c_name = c_name;
		this.t_no = t_no;
		this.t_type = t_type;
		this.t_date = t_date;
		this.t_cnt = t_cnt;
	}
	


	//입출고 등록
	public Dto(String p_code, String c_code, String t_no, String t_type, String t_date, int t_cnt) {
		super();
		this.p_code = p_code;
		this.c_code = c_code;
		this.t_no = t_no;
		this.t_type = t_type;
		this.t_date = t_date;
		this.t_cnt = t_cnt;
	}



	//제품조회
	public Dto(String p_code, String p_name, String p_size, String p_incost, String p_outcost) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_size = p_size;
		this.p_incost = p_incost;
		this.p_outcost = p_outcost;
	}
	
	


	public String getT_profit() {
		return t_profit;
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
	public String getC_code() {
		return c_code;
	}
	public String getC_name() {
		return c_name;
	}
	public String getC_tel() {
		return c_tel;
	}
	public String getT_no() {
		return t_no;
	}
	public String getT_type() {
		return t_type;
	}
	public String getT_date() {
		return t_date;
	}
	public String getP_incost() {
		return p_incost;
	}
	public String getP_outcost() {
		return p_outcost;
	}
	public int getT_cnt() {
		return t_cnt;
	}

	
	
}
