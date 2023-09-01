package track;

public class Sub4Dto {
	private String test_date, city_name, avg, stat;

	public Sub4Dto(String test_date, String city_name, String avg, String stat) {
		super();
		this.test_date = test_date;
		this.city_name = city_name;
		this.avg = avg;
		this.stat = stat;
	}

	public String getTest_date() {
		return test_date;
	}

	public String getCity_name() {
		return city_name;
	}

	public String getAvg() {
		return avg;
	}

	public String getStat() {
		return stat;
	}
	
}
