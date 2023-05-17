package f_method;

public class J0119_2 {

	public static void main(String[] args) {
		J0119_2_sub sub=new J0119_2_sub();
		
		String gubun=sub.getGubun("200");
		System.out.println(gubun);
		
		int kor=80;
		String total= sub.getTotal(kor, "90");
		System.out.println(total);
		
	}

}
