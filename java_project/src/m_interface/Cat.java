package m_interface;

public class Cat extends Animal implements InterAA, InterBB {
	
	@Override
	public String getVoice() {		//반드시 interface클래스와 자식클래스의 메소드 모두 반드시 public사용
		return "야옹~";
	}
	
	@Override
	public int getLegCount() {
		return 4;
	}
	
	@Override
	String getName() {
		return "고양이";
	}
	
	@Override
	public String getColor() {
		return "노랑";
	}
}
