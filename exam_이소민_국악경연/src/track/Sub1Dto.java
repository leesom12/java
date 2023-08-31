package track;

public class Sub1Dto {
	private String entry_no;
	private int score1, score2, score3, score4, score5, s_max, s_min, s_tot;
	private double s_ave;
	
	
	public Sub1Dto(String entry_no, int score1, int score2, int score3, int score4, int score5, int s_max, int s_min,
			int s_tot, double s_ave) {
		super();
		this.entry_no = entry_no;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
		this.score5 = score5;
		this.s_max = s_max;
		this.s_min = s_min;
		this.s_tot = s_tot;
		this.s_ave = s_ave;
	}


	public String getEntry_no() {
		return entry_no;
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


	public int getS_max() {
		return s_max;
	}


	public int getS_min() {
		return s_min;
	}


	public int getS_tot() {
		return s_tot;
	}


	public double getS_ave() {
		return s_ave;
	}
	
	
}
