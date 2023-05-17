package g_생성자;

public class J0126_dto {
	
	// 생성자 메소드; 
	// return이 아무것도 없고, 소괄호 안에 매개변수가 없고, 클래스 이름과 이름이 같은 생성자 메소드: 기본 생성자;
	// 굳이 만들지 않아도 이미 존재함. 물론 만들어도 됨.
	
	String name;
	int age;
	
	J0126_dto(){}
	J0126_dto(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
