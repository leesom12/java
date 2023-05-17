package f_method;

public class J0125_1_sub {

	int getTotal(String string, int i) {
		return Integer.parseInt(string)+i;
	}
	
	int getTotal(int num1, String num2) {
		return num1+Integer.parseInt(num2);
	}
	
	int getTotal(int[]a) {
		int total=0;
		for(int k=0; k<a.length; k++) total+=a[k];
		return total;
	}

	int[] getTotal(int num1, int num2) {
		int[] arr=new int[2];
		arr[0]=num1+num2;
		arr[1]=(num1+num2)/2;
		return arr;
	}
	
	String[] getTotal(int a, int b, int c) {
		String[] result=new String[2];
		result[0]=Integer.toString(a+b+c);
		result[1]=Integer.toString((a+b+c)/3);
		return result;
	}
	
	int getTotal(int[]a, String[]b) {
		int total_1=0;
		for(int k=0; k<a.length; k++) total_1+=a[k];
		int total_2=0;
		for(int k=0; k<b.length; k++) total_2+=Integer.parseInt(b[k]);
		return total_1+total_2;
	}
	
	
}
