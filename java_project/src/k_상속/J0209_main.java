package k_상속;

public class J0209_main {

	public static void main(String[] args) {
		J0209_a aa= new J0209_a();
		int total= aa.getTotal(10, 20);
		
		J0209_b bb= new J0209_b();
		String name = bb.getName();
		int to= bb.getTotal(20, 30);		//b클래스는 a클래스를 상속받았기 때문에 b클래스에서도 a의 메소드를 쓸 수 있음
		
		J0209_c cc= new J0209_c();
		int age= cc.getAge();
		int tot= cc.getTotal(30, 40);
		String name2= cc.getName();
	}
}
