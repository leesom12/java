package dto;

public class AdminDto {
	private String id, name, job, tell, mobile, email, reg_date, login_time, delete;
	private int pass_length;

	//조회
	public AdminDto(String id, String name, String job, String tell, String mobile, String email, String reg_date,
			String login_time, int pass_length, String delete) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.tell = tell;
		this.mobile = mobile;
		this.email = email;
		this.reg_date = reg_date;
		this.login_time = login_time;
		this.pass_length= pass_length;
		this.delete= delete;
	}

	
	public String getDelete() {
		return delete;
	}
	
	public int getPass_length() {
		return pass_length;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	public String getTell() {
		return tell;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getLogin_time() {
		return login_time;
	}
	
	
}
