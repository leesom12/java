package dto;

public class StudentSaveDto {
	private String syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3;

	public StudentSaveDto(String syear, String sclass, String sno, String sname, String birth, String gender,
			String tel1, String tel2, String tel3) {
		super();
		this.syear = syear;
		this.sclass = sclass;
		this.sno = sno;
		this.sname = sname;
		this.birth = birth;
		this.gender = gender;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
	}

	public String getSyear() {
		return syear;
	}

	public String getSclass() {
		return sclass;
	}

	public String getSno() {
		return sno;
	}

	public String getSname() {
		return sname;
	}

	public String getBirth() {
		return birth;
	}

	public String getGender() {
		return gender;
	}

	public String getTel1() {
		return tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public String getTel3() {
		return tel3;
	}
	
	
}
