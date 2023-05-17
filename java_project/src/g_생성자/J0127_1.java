package g_생성자;

public class J0127_1 {

	public static void main(String[] args) {
		J0127_dto dto= new J0127_dto();
		String id=dto.getId();
		System.out.println("id: "+id);
		dto.setId("101");
		id=dto.getId();
		System.out.println("id: "+id);
		dto.setId("201");
		System.out.println("id: "+dto.getId());
		String name= dto.getName();
		
		J0127_dto dto2= new J0127_dto("301");
		id=dto2.getId();
		System.out.println(id);
		dto2.setName("홍길동");
		name=dto2.getName();
		
		J0127_dto dto3=new J0127_dto("301","이상화","대전",25);
		System.out.println(dto3.getName());
		
		J0127_dto dto4=new J0127_dto();
		dto4.setId("301");
		dto4.setName("이상화");
		dto4.setArea("대전");
		dto4.setAge(25);
		id=dto4.getId();
		name= dto4.getName();
		String area=dto4.getArea();
		int age=dto4.getAge();
		
		J0127_dto dto5= new J0127_dto(25, "301","이상화","대전");
		
	}
}
