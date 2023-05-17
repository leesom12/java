package f_method;

public class J0125_3_sub {
	
	int getPay(int basic, String gender) {
		int result=0;
		if(gender.equals("1")) result=basic+100000;
		else if(gender.equals("2")) result=basic+200000;
		return result;
	}

}
