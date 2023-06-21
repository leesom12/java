package dto;

public class AdminDto {
	private String id, name, area, address, mobile, gender, h_travel, h_reading, h_sports, reg_date, login_time, update_date, exit_date;
	private int pass_length;
	
	
	//전체조회
	public AdminDto(String id, String name, String area, String mobile, String reg_date, String login_time,
			String exit_date) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.mobile = mobile;
		this.reg_date = reg_date;
		this.login_time = login_time;
		this.exit_date = exit_date;
	}
	
	
	//상세조회
	public AdminDto(String id, String name, String area, String address, String mobile, String gender, String h_travel,
			String h_reading, String h_sports, String reg_date, String login_time, String update_date, String exit_date,
			int pass_length) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.address = address;
		this.mobile = mobile;
		this.gender = gender;
		this.h_travel = h_travel;
		this.h_reading = h_reading;
		this.h_sports = h_sports;
		this.reg_date = reg_date;
		this.login_time = login_time;
		this.update_date = update_date;
		this.exit_date = exit_date;
		this.pass_length = pass_length;
	}



	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getArea() {
		return area;
	}
	public String getAddress() {
		return address;
	}
	public String getMobile() {
		return mobile;
	}
	public String getGender() {
		return gender;
	}
	public String getH_travel() {
		return h_travel;
	}
	public String getH_reading() {
		return h_reading;
	}
	public String getH_sports() {
		return h_sports;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getLogin_time() {
		return login_time;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public String getExit_date() {
		return exit_date;
	}
	public int getPass_length() {
		return pass_length;
	}

	

	
}
