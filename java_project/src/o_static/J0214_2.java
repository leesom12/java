package o_static;

public class J0214_2 {
	String name;
	J0214_1_sub sub;
	
	int getTotal(int a, int b) {
		sub= new J0214_1_sub();
		System.out.println("sub: "+sub);
		return a+b;
	}
	
	
}
