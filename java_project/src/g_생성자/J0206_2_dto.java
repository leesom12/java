package g_생성자;

public class J0206_2_dto {
	String id, name, result;
	int kor, eng, mat;
	double ave;
	
	public J0206_2_dto(String id, String name, int kor, int eng, int mat, double ave, String result) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.ave = ave;
		this.result = result;
	}

	public String getId() {
		return id;
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

	public double getAve() {
		return ave;
	}
	
}
