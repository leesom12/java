package dto;

public class SUb3Dto {
	private String v_name, v_birth, v_age, v_gender,m_no, v_time, v_confirm;

	public SUb3Dto(String v_name, String v_birth, String v_age, String v_gender, String m_no, String v_time,
			String v_confirm) {
		super();
		this.v_name = v_name;
		this.v_birth = v_birth;
		this.v_age = v_age;
		this.v_gender = v_gender;
		this.m_no = m_no;
		this.v_time = v_time;
		this.v_confirm = v_confirm;
	}

	public String getV_name() {
		return v_name;
	}

	public String getV_birth() {
		return v_birth;
	}

	public String getV_age() {
		return v_age;
	}

	public String getV_gender() {
		return v_gender;
	}

	public String getM_no() {
		return m_no;
	}

	public String getV_time() {
		return v_time;
	}

	public String getV_confirm() {
		return v_confirm;
	}
	
	
}
