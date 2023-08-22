package dto;

public class InjectionDto {
	private String p_no, p_name, p_birth, p_gender, p_tel, p_city, p_seno, i_code, p_date,
	i_name, i_age, p_age;
	private int count;

	//백신접종건수
	public InjectionDto(String i_code, String i_name, int count) {
		super();
		this.i_code = i_code;
		this.i_name = i_name;
		this.count = count;
	}

	//접종이력조회
	public InjectionDto(String p_no, String p_name, String p_seno, String i_code, String p_date, String i_name) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_seno = p_seno;
		this.i_code = i_code;
		this.p_date = p_date;
		this.i_name = i_name;
	}
	

	//예방접종등록
	public InjectionDto(String p_no, String p_seno, String i_code, String p_date) {
		super();
		this.p_no = p_no;
		this.p_seno = p_seno;
		this.i_code = i_code;
		this.p_date = p_date;
	}

	//고객조회
	public InjectionDto(String p_no, String p_name, String p_birth, String p_gender, String p_tel, String p_city,
			String p_age) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_birth = p_birth;
		this.p_gender = p_gender;
		this.p_tel = p_tel;
		this.p_city = p_city;
		this.p_age = p_age;
	}
	
	
	public int getCount() {
		return count;
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
	public String getP_city() {
		return p_city;
	}
	public String getP_seno() {
		return p_seno;
	}
	public String getI_code() {
		return i_code;
	}
	public String getP_date() {
		return p_date;
	}
	public String getI_name() {
		return i_name;
	}
	public String getI_age() {
		return i_age;
	}
	public String getP_age() {
		return p_age;
	}
	
	
}
