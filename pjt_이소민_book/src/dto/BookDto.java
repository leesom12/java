package dto;

public class BookDto {
	private String p_no, p_name, p_birth, p_gender, p_tel, p_reg_date, p_rentno, b_code, p_s_date, p_e_date, b_name, b_publisher;
	private int b_rent_count;
	
	
	//도서별 대여 건수
	public BookDto(String b_code, String b_name, String b_publisher) {
		super();
		this.b_code = b_code;
		this.b_name = b_name;
		this.b_publisher = b_publisher;
	}


	//도서 대여 이력 조회
	public BookDto(String p_no, String p_name, String p_rentno, String b_code, String p_s_date, String p_e_date,
			String b_name) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_rentno = p_rentno;
		this.b_code = b_code;
		this.p_s_date = p_s_date;
		this.p_e_date = p_e_date;
		this.b_name = b_name;
	}


	//도서대여등록
	public BookDto(String p_no, String p_rentno, String b_code, String p_s_date, String p_e_date) {
		super();
		this.p_no = p_no;
		this.p_rentno = p_rentno;
		this.b_code = b_code;
		this.p_s_date = p_s_date;
		this.p_e_date = p_e_date;
	}


	//회원조회
	public BookDto(String p_no, String p_name, String p_birth, String p_gender, String p_tel, String p_reg_date) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_birth = p_birth;
		this.p_gender = p_gender;
		this.p_tel = p_tel;
		this.p_reg_date = p_reg_date;
	}
	
	
	public String getP_no() {
		return p_no;
	}
	public String getP_name() {
		return p_name;
	}
	public String getP_birth() {
		return p_birth;
	}
	public String getP_gender() {
		return p_gender;
	}
	public String getP_tel() {
		return p_tel;
	}
	public String getP_reg_date() {
		return p_reg_date;
	}
	public String getP_rentno() {
		return p_rentno;
	}
	public String getB_code() {
		return b_code;
	}
	public String getP_s_date() {
		return p_s_date;
	}
	public String getP_e_date() {
		return p_e_date;
	}
	public String getB_name() {
		return b_name;
	}
	public String getB_publisher() {
		return b_publisher;
	}
	public int getB_rent_count() {
		return b_rent_count;
	}
	
	
}
