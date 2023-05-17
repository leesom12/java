package dto;

public class BookDto {
	private String p_no, p_name, code, b_name, rent_date, return_date, publisher;
	private int no, num;
	
	//대여 등록
	public BookDto(int no, String p_no, String code, String rent_date) {
		super();
		this.no = no;
		this.p_no = p_no;
		this.code = code;
		this.rent_date = rent_date;
	}
	
	
	//대여 이력 조회
	public BookDto(int no, String p_no, String p_name, String code, String b_name, String rent_date,
			String return_date) {
		super();
		this.no = no;
		this.p_no = p_no;
		this.p_name = p_name;
		this.code = code;
		this.b_name = b_name;
		this.rent_date = rent_date;
		this.return_date = return_date;
	}


	//건수 조회
	public BookDto(String code, String b_name, String publisher) {
		super();
		this.code = code;
		this.b_name = b_name;
		this.publisher = publisher;
	}


	public String getB_name() {
		return b_name;
	}
	public String getP_name() {
		return p_name;
	}
	public int getNo() {
		return no;
	}
	public String getP_no() {
		return p_no;
	}
	public String getCode() {
		return code;
	}
	public String getRent_date() {
		return rent_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getNum() {
		return num;
	}
	
	
}
