package f_method;

public class J0119_2_sub {
	
	String getGubun(String a) {
		int re=100-Integer.parseInt(a);
		String result= Integer.toString(re);
		return result;
	}
	
	String getTotal(int a, String b) {
		int total=a+Integer.parseInt(b);
		return Integer.toString(total);
	}
}
