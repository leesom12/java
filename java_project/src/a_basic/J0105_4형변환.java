package a_basic;

public class J0105_4형변환 {

	public static void main(String[] args) {
		//int를 double로
		int total=185;
		int count=3;
		double ave=total/(double)count;  
		System.out.println("ave: "+ave);
		
		//double을 int로
		double d=85.85555;
		int dd=(int)d;
		System.out.println("dd: "+dd);
		
		//String을 int로
		String s="100";
		int ss=Integer.parseInt(s);
		System.out.println("ss: "+ss);
		
		//int를 String으로
		int i=85;
		String ii=Integer.toString(i);
		System.out.println("ii: "+ii);
		
			}

}
