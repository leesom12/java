package dto;

public class ProductDto {
	private String no, p_name, detail, attach, p_size, p_level, reg_id, reg_name, reg_date, update_date, delete_date, strPrice;
	private int hit, price;
	
	
	//수정
	public ProductDto(String no, String p_name, String detail, String p_size, String p_level, String attach,
			String update_date, int price) {
		super();
		this.no = no;
		this.p_name = p_name;
		this.detail = detail;
		this.p_size = p_size;
		this.p_level = p_level;
		this.attach = attach;
		this.update_date = update_date;
		this.price = price;
	}


	//이전글, 다음글
	public ProductDto(String no, String p_name) {
		super();
		this.no = no;
		this.p_name = p_name;
	}


	//상세조회
	public ProductDto(String no, String p_name, String detail, String attach, String p_size, String p_level, String reg_name,
			String reg_date, String update_date, String strPrice, int hit, int price) {
		super();
		this.no = no;
		this.p_name = p_name;
		this.detail = detail;
		this.attach = attach;
		this.p_size = p_size;
		this.p_level = p_level;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.strPrice = strPrice;
		this.hit = hit;
		this.price = price;
	}

	
	//전체조회
	public ProductDto(String no, String p_name, String strPrice, String attach, int hit, String reg_date) {
		super();
		this.no = no;
		this.p_name = p_name;
		this.strPrice = strPrice;
		this.attach = attach;
		this.hit = hit;
		this.reg_date = reg_date;
	}


	//등록
	public ProductDto(String no, String p_name, String detail, String p_size, int price, String p_level, String attach, String reg_id,
			String reg_date) {
		super();
		this.no = no;
		this.p_name = p_name;
		this.detail = detail;
		this.p_size = p_size;
		this.price = price;
		this.p_level = p_level;
		this.attach = attach;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}
	
	
	public String getStrPrice() {
		return strPrice;
	}
	public String getNo() {
		return no;
	}
	public String getP_name() {
		return p_name;
	}
	public String getDetail() {
		return detail;
	}
	public String getAttach() {
		return attach;
	}
	public String getP_size() {
		return p_size;
	}
	public String getP_level() {
		return p_level;
	}
	public String getReg_id() {
		return reg_id;
	}
	public String getReg_name() {
		return reg_name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public String getDelete_date() {
		return delete_date;
	}
	public int getHit() {
		return hit;
	}
	public int getPrice() {
		return price;
	}
	
	
}
