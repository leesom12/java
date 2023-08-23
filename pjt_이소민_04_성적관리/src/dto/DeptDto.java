package dto;

public class DeptDto {
	private String syear, sclass, tname, ave_kor, ave_eng, ave_mat;
	private int sum_kor, sum_eng, sum_mat;
	
	
	public DeptDto(String syear, String sclass, String tname, String ave_kor, String ave_eng, String ave_mat,
			int sum_kor, int sum_eng, int sum_mat) {
		super();
		this.syear = syear;
		this.sclass = sclass;
		this.tname = tname;
		this.ave_kor = ave_kor;
		this.ave_eng = ave_eng;
		this.ave_mat = ave_mat;
		this.sum_kor = sum_kor;
		this.sum_eng = sum_eng;
		this.sum_mat = sum_mat;
	}
	public String getSyear() {
		return syear;
	}
	public String getSclass() {
		return sclass;
	}
	public String getTname() {
		return tname;
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
