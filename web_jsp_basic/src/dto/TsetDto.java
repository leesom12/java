package dto;

public class TsetDto {
	private String name, area;
	private int age;
	public TsetDto(String name, String area, int age) {
		super();
		this.name = name;
		this.area = area;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public String getArea() {
		return area;
	}
	public int getAge() {
		return age;
	}
}
