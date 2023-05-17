package h_arraylist;

public class J0207_4_dto {
	String id, name, depart, rank;
	int age;
	
	public J0207_4_dto(String id, String name, int age, String depart, String rank) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.depart = depart;
		this.rank = rank;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDepart() {
		return depart;
	}
	public String getRank() {
		return rank;
	}
	public int getAge() {
		return age;
	}
	
}
