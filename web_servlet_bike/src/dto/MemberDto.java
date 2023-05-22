package dto;

public class MemberDto {
	private String id, name, password, area, address, mobile_1, mobile_2, mobile_3, gender, 
				   travel, reading, sports, reg_date, update_date, login_time, exit_date, level;
	private int pass_len;
	

	//회원정보 수정
	public MemberDto(String id, String name, String area, String address, String mobile_1, String mobile_2,
			String mobile_3, String gender, String travel, String reading, String sports, String update_date) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.address = address;
		this.mobile_1 = mobile_1;
		this.mobile_2 = mobile_2;
		this.mobile_3 = mobile_3;
		this.gender = gender;
		this.travel = travel;
		this.reading = reading;
		this.sports = sports;
		this.update_date = update_date;
	}

	//상세조회
	public MemberDto(String id, String name, String area, String address, String mobile_1, String mobile_2,
			String mobile_3, String gender, String travel, String reading, String sports, String reg_date,
			String update_date, String login_time, String exit_date, String level, int pass_len) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.address = address;
		this.mobile_1 = mobile_1;
		this.mobile_2 = mobile_2;
		this.mobile_3 = mobile_3;
		this.gender = gender;
		this.travel = travel;
		this.reading = reading;
		this.sports = sports;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.login_time = login_time;
		this.exit_date = exit_date;
		this.level = level;
		this.pass_len = pass_len;
	}

	//로그인
	public MemberDto(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}

	//회원가입
	public MemberDto(String id, String name, String password, String area, String address, String mobile_1,
			String mobile_2, String mobile_3, String gender, String travel, String reading, String sports,
			String reg_date, int pass_len) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.area = area;
		this.address = address;
		this.mobile_1 = mobile_1;
		this.mobile_2 = mobile_2;
		this.mobile_3 = mobile_3;
		this.gender = gender;
		this.travel = travel;
		this.reading = reading;
		this.sports = sports;
		this.reg_date = reg_date;
		this.pass_len = pass_len;
	}
	
	public String getLevel() {
		return level;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getArea() {
		return area;
	}
	public String getAddress() {
		return address;
	}
	public String getMobile_1() {
		return mobile_1;
	}
	public String getMobile_2() {
		return mobile_2;
	}
	public String getMobile_3() {
		return mobile_3;
	}
	public String getGender() {
		return gender;
	}
	public String getTravel() {
		return travel;
	}
	public String getReading() {
		return reading;
	}
	public String getSports() {
		return sports;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public String getLogin_time() {
		return login_time;
	}
	public String getExit_date() {
		return exit_date;
	}
	public int getPass_len() {
		return pass_len;
	}
	
	
}
