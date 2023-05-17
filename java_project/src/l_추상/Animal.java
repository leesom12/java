package l_추상;

public abstract class Animal {
	
	abstract String getVoice();		
//		추상 메소드: return 타입과 메소드 이름만 존재하는 메소드
//		메소드 중에 추상 메소드가 하나라고 존재하면 클래스도 추상 클래스가 되어야 함
//		return값은 자식 클래스에서 지정
//		자식 클래스에서는 부모 클래스의 추상 메소드를 사용하지 않으면 안 됨	
	
	abstract int getWeight();
	
	String getColor() {
		return "";
	}
}
