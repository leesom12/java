package l_추상;

public class J0210_main {

	public static void main(String[] args) {
		Cat cat= new Cat();
		String voice= cat.getVoice();
		String height= cat.getHeight();
		System.out.println("cat: "+voice);
		
		Animal cat2= new Cat();				// 자식 클래스는 부모 타입으로 만들어질 수 있다. 부모는 자식 타입으로 못 만들어짐
//		Animal ani= new Animal();			// 안 만들어짐. 추상클래스는 스스로 생성되지 못함. 상속되어야 사용 가능
		Cat cat3= new Cat();
		
		// cat2는 Animal에 있는 메소드만 보이고 cat3는 Animal과 Cat에 있는 메소드 전부 사용 가능
		
		Dog dog= new Dog();
		voice= dog.getVoice();
		System.out.println("dog: "+voice);
		Animal dog2= new Dog();
	}

}
