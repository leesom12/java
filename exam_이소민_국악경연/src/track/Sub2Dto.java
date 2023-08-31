package track;

public class Sub2Dto {
	private String entry_no, entry_name, entry_gender, entry_birth, entry_type, entry_area, s_ave;
	private int score1, score2, score3, score4, score5, s_tot;
	public Sub2Dto(String entry_no, String entry_name, String entry_gender, String entry_birth, String entry_type,
			String entry_area, String s_ave, int score1, int score2, int score3, int score4, int score5, int s_tot) {
		super();
		this.entry_no = entry_no;
		this.entry_name = entry_name;
		this.entry_gender = entry_gender;
		this.entry_birth = entry_birth;
		this.entry_type = entry_type;
		this.entry_area = entry_area;
		this.s_ave = s_ave;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
		this.score5 = score5;
		this.s_tot = s_tot;
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
	public String getS_ave() {
		return s_ave;
	}
	public int getScore1() {
		return score1;
	}
	public int getScore2() {
		return score2;
	}
	public int getScore3() {
		return score3;
	}
	public int getScore4() {
		return score4;
	}
	public int getScore5() {
		return score5;
	}
	public int getS_tot() {
		return s_tot;
	}
	
	
}	