package g_생성자;

public class J0203_이소민_dto {
	String name, result;
	int kor, eng, mat, ave;
	
	public J0203_이소민_dto(String name, int kor, int eng, int mat, int ave, String result) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.ave = ave;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public String getResult() {
		return result;
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

	public int getAve() {
		return ave;
	}
	
}
