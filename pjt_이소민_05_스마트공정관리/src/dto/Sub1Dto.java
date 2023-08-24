package dto;

public class Sub1Dto {
	private String p_code, p_name, p_size, p_type, p_price;

	public Sub1Dto(String p_code, String p_name, String p_size, String p_type, String p_price) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_size = p_size;
		this.p_type = p_type;
		this.p_price = p_price;
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

	public String getP_price() {
		return p_price;
	}
	
	
}
