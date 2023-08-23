package dto;

public class ScoreListDto {
	private String syear, sclass, sno, sname, gender, ave, ave_kor, ave_eng, ave_mat;
	private int kor, eng, mat, total, sum_kor, sum_eng, sum_mat;
	
	
	//학년별
	public ScoreListDto(String syear, String ave_kor, String ave_eng, String ave_mat, int sum_kor, int sum_eng,
			int sum_mat) {
		super();
		this.syear = syear;
		this.ave_kor = ave_kor;
		this.ave_eng = ave_eng;
		this.ave_mat = ave_mat;
		this.sum_kor = sum_kor;
		this.sum_eng = sum_eng;
		this.sum_mat = sum_mat;
	}


	//학생별
	public ScoreListDto(String syear, String sclass, String sno, String sname, String gender, String ave, int kor,
			int eng, int mat, int total) {
		super();
		this.syear = syear;
		this.sclass = sclass;
		this.sno = sno;
		this.sname = sname;
		this.gender = gender;
		this.ave = ave;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = total;
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



	public String getGender() {
		return gender;
	}



	public String getAve() {
		return ave;
	}



	public String getAve_kor() {
		return ave_kor;
	}



	public String getAve_eng() {
		return ave_eng;
	}



	public String getAve_mat() {
		return ave_mat;
	}



	public int getKor() {
		return kor;
	}



	public int getEng() {
		return eng;
	}



	public int getMat() {
		return mat;
	}



	public int getTotal() {
		return total;
	}



	public int getSum_kor() {
		return sum_kor;
	}



	public int getSum_eng() {
		return sum_eng;
	}



	public int getSum_mat() {
		return sum_mat;
	}
	
	

	
	
	
}
