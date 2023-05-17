package m_interface;

public class J0210_main {

	public static void main(String[] args) {
		Cat cat1 = new Cat();
		String voice=cat1.getVoice();
		System.out.println("voice: "+voice);
		Animal cat2 = new Cat();
		InterAA cat3= new Cat();
		InterBB cat4= new Cat();
		
		String name=cat2.getName();
		voice=cat3.getVoice();
		String color=cat4.getColor();
		
		System.out.println(name);
		System.out.println(voice);
		System.out.println(color);

	}

}
