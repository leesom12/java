package track;

public class Sub2Dto {
	private String empno, empname, resvdate, seatno, office, callno;

	public Sub2Dto(String empno, String empname, String resvdate, String seatno, String office, String callno) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.resvdate = resvdate;
		this.seatno = seatno;
		this.office = office;
		this.callno = callno;
	}

	public String getEmpno() {
		return empno;
	}

	public String getEmpname() {
		return empname;
	}

	public String getResvdate() {
		return resvdate;
	}

	public String getSeatno() {
		return seatno;
	}

	public String getOffice() {
		return office;
	}

	public String getCallno() {
		return callno;
	}
	
	
}
