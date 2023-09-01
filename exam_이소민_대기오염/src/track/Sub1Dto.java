package track;

public class Sub1Dto {
	private String city_code, city_name, area_code, area_name, city_tel, city_admin, city_level;

	public Sub1Dto(String city_code, String city_name, String area_code, String area_name, String city_tel,
			String city_admin, String city_level) {
		super();
		this.city_code = city_code;
		this.city_name = city_name;
		this.area_code = area_code;
		this.area_name = area_name;
		this.city_tel = city_tel;
		this.city_admin = city_admin;
		this.city_level = city_level;
	}

	public String getCity_code() {
		return city_code;
	}

	public String getCity_name() {
		return city_name;
	}

	public String getArea_code() {
		return area_code;
	}

	public String getArea_name() {
		return area_name;
	}

	public String getCity_tel() {
		return city_tel;
	}

	public String getCity_admin() {
		return city_admin;
	}

	public String getCity_level() {
		return city_level;
	}
	
	
}
