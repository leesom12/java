package dto;

public class ScoreSaveDto {
	private String syear, sclass, sno, kor, eng, mat;

	public ScoreSaveDto(String syear, String sclass, String sno, String kor, String eng, String mat) {
		super();
		this.syear = syear;
		this.sclass = sclass;
		this.sno = sno;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
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

	public String getKor() {
		return kor;
	}

	public String getEng() {
		return eng;
	}

	public String getMat() {
		return mat;
	}
	
	
}
