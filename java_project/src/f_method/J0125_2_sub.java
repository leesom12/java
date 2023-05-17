package f_method;

public class J0125_2_sub {
	
	int getTotal(int a, int b, int c) {
		return a+b+c;
	}
	
	double getAve(int total, int count) {
		return total/(double)count;
	}
	
	String getResult(double ave) {
		String result="";
		if(ave>=90) result="수";
		else if(ave>=80) result="우";
		else if(ave>=70) result="미";
		else if(ave>=60) result="양";
		else result="가";
		return result;
	}

}
