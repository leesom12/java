package track;

public class Sub3Dto {
	private String test_date, test_ampm, pollution, city_code, city_name, area_name;
	private int test_value;
	
	public Sub3Dto(String test_date, String test_ampm, String pollution, String city_code, String city_name,
			String area_name, int test_value) {
		super();
		this.test_date = test_date;
		this.test_ampm = test_ampm;
		this.pollution = pollution;
		this.city_code = city_code;
		this.city_name = city_name;
		this.area_name = area_name;
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
	public String getCity_name() {
		return city_name;
	}
	public String getArea_name() {
		return area_name;
	}
	public int getTest_value() {
		return test_value;
	}
	
	
}
