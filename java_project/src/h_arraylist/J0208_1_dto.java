package h_arraylist;

public class J0208_1_dto {
	String grade, ban, beonho, name;
	int kor, eng, mat, total, rank;
	
	public J0208_1_dto() {
		super();
	}

	public J0208_1_dto(String grade, String ban, String beonho, String name, int kor, int eng, int mat, int total) {
		super();
		this.grade = grade;
		this.ban = ban;
		this.beonho = beonho;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total= total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}

	public String getBeonho() {
		return beonho;
	}

	public void setBeonho(String beonho) {
		this.beonho = beonho;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
