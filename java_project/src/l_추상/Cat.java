package l_추상;

public class Cat extends Animal {
	
	@Override				//부모 클래스의 메소드를 그대로 가져다 쓸 때 사용, 부모 클래스의 메소드를 재사용한 것인지 확인하기 위함
	String getVoice() {
		return "야옹";
	}
	
	@Override
	int getWeight() {
		return 3;
	}
	
	String getHeight() {
		return "25cm";
	}
}
