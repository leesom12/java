package b_if;

public class J0105_1 {

	public static void main(String[] args) {
		int a=10, b=5;
		if(a!=b){			// 같지 않다
			System.out.println("true1");
		}
		if(a>b && a==b) {	//그리고
			System.out.println("true2");
		}
		if(a>b || a==b) {	//또는
			System.out.println("true3");
		}
		if(a>b) {
			if(a!=b) {
				System.out.println("true4");
			}
		}
		if(a>b && a!=b) {
			System.out.println("true5");
		}
		System.out.println("끝");

	}
}
