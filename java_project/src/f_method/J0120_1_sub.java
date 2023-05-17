package f_method;

public class J0120_1_sub {
	
	int getTotal_1(int a, int b){
		int total=a+b;
		return total;
	}
	
	int getTotal_2(int a, int b, int c) {
		return a+b+c;
	}
	
	String getTotal_3(int a, int b) {
		String total=Integer.toString(a+b);
		return total;
	}
	
	int getAve_1(int total, int count) {
		int ave=total/count;
		return ave;
	}
	
	int getAve_2(String total, int count) {
		int ave=Integer.parseInt(total)/count;
		return ave;
	}
	
	String getAve_3(int total, String count) {
		int ave=total/Integer.parseInt(count);
		return Integer.toString(ave);
	}
	
	String getAve_4(String total, String count) {
		int ave=Integer.parseInt(total)/Integer.parseInt(count);
		return Integer.toString(ave); 
	}
	
	int getTotal_4(int a, String b, int c, String d) {
		int total= a+ Integer.parseInt(b)+ c+ Integer.parseInt(d);
		return total;
	}
	
	double getAve_5(int total, String count) {
		double ave= (double)total/Integer.parseInt(count);
		return ave;
	}
	
}