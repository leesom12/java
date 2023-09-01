package track;

public class Sub2Dto {
	private String test_date, test_ampm, pollution, city_code;
	private int test_value;
	
	public Sub2Dto(String test_date, String test_ampm, String pollution, String city_code, int test_value) {
		super();
		this.test_date = test_date;
		this.test_ampm = test_ampm;
		this.pollution = pollution;
		this.city_code = city_code;
		this.test_value = test_value;
	}

	public String getTest_date() {
		return test_date;
	}

	public String getTest_ampm() {
		return test_ampm;
	}

	public String getPollution() {
		return pollution;
	}

	public String getCity_code() {
		return city_code;
	}

	public int getTest_value() {
		return test_value;
	}
	
	
}
