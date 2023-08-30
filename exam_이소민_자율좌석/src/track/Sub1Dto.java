package track;

public class Sub1Dto {
	private String resvno, empno, resvdate, seatno;

	public Sub1Dto(String resvno, String empno, String resvdate, String seatno) {
		super();
		this.resvno = resvno;
		this.empno = empno;
		this.resvdate = resvdate;
		this.seatno = seatno;
	}

	public String getResvno() {
		return resvno;
	}

	public String getEmpno() {
		return empno;
	}

	public String getResvdate() {
		return resvdate;
	}

	public String getSeatno() {
		return seatno;
	}
	
	
}
