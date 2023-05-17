package f_method;

public class J0120_3_sub {
	
	int getTotal(int[]a) {
		int total=0;
		for(int k=0; k<a.length; k++) total+=a[k];
		return total;
	}
	
	int getAve(int[]a, int count) {
		int total=0;
		for(int k=0; k<a.length; k++) total+=a[k];
		return total/count;
	}
	
	int getAve(int[]a) {
		int total=0;
		for(int k=0; k<a.length;k++) total+=a[k];
		return total/a.length;
	}

}
