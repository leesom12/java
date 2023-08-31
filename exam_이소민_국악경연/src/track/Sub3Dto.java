package track;

public class Sub3Dto {

	private String entry_no, entry_name, entry_gender, entry_birth, entry_type, entry_area, s_tot, s_ave;
	private int rank;
	
	public Sub3Dto(String entry_no, String entry_name, String entry_gender, String entry_birth, String entry_type,
			String entry_area, String s_tot, String s_ave, int rank) {
		super();
		this.entry_no = entry_no;
		this.entry_name = entry_name;
		this.entry_gender = entry_gender;
		this.entry_birth = entry_birth;
		this.entry_type = entry_type;
		this.entry_area = entry_area;
		this.s_tot = s_tot;
		this.s_ave = s_ave;
		this.rank = rank;
	}

	public String getEntry_no() {
		return entry_no;
	}

	public String getEntry_name() {
		return entry_name;
	}

	public String getEntry_gender() {
		return entry_gender;
	}

	public String getEntry_birth() {
		return entry_birth;
	}

	public String getEntry_type() {
		return entry_type;
	}

	public String getEntry_area() {
		return entry_area;
	}

	public String getS_tot() {
		return s_tot;
	}

	public String getS_ave() {
		return s_ave;
	}

	public int getRank() {
		return rank;
	}

	
}
