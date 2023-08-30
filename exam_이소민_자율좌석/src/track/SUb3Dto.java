package track;

public class SUb3Dto {
	private String empno, empname, deptname;
	private int count;
	public SUb3Dto(String empno, String empname, String deptname, int count) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.deptname = deptname;
		this.count = count;
	}
	public String getEmpno() {
		return empno;
	}
	public String getEmpname() {
		return empname;
	}
	public String getDeptname() {
		return deptname;
	}
	public int getCount() {
		return count;
	}
	
	
}
