package l_추상;

public class Dog extends Animal{
	
	@Override
	String getVoice() {
		return "멍멍";
	}
	
	@Override
	int getWeight() {
		return 5;
	}
}
