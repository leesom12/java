package track;

public class Sub1Dto {

	private String saleno, oildate, oiltype, amount, paytype, custno, creditcart, oilcost;

	public Sub1Dto(String saleno, String oildate, String oiltype, String amount, String paytype, String custno,
			String creditcart, String oilcost) {
		super();
		this.saleno = saleno;
		this.oildate = oildate;
		this.oiltype = oiltype;
		this.amount = amount;
		this.paytype = paytype;
		this.custno = custno;
		this.creditcart = creditcart;
		this.oilcost = oilcost;
	}

	public String getSaleno() {
		return saleno;
	}

	public String getOildate() {
		return oildate;
	}

	public String getOiltype() {
		return oiltype;
	}

	public String getAmount() {
		return amount;
	}

	public String getPaytype() {
		return paytype;
	}

	public String getCustno() {
		return custno;
	}

	public String getCreditcart() {
		return creditcart;
	}

	public String getOilcost() {
		return oilcost;
	}
	
	
}
