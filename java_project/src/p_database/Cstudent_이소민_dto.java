package p_database;

public class Cstudent_이소민_dto {
	String sid, sname;
	int age;
	
	public Cstudent_이소민_dto(String sid, String sname, int age) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
	}

	public String getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public int getAge() {
		return age;
	}
}
