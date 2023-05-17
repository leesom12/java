package dto;

public class MemberDto {
	private String no, name, birth, gender, tell, reg_date;
	
	//회원 조회
	public MemberDto(String no, String name, String birth, String gender, String tell, String reg_date) {
		super();
		this.no = no;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.tell = tell;
		this.reg_date = reg_date;
	}

	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getGender() {
		return gender;
	}

	public String getTell() {
		return tell;
	}

	public String getReg_date() {
		return reg_date;
	}
	
	
}
