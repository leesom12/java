package f_method;

public class J0119_1 {

	public static void main(String[] args) {
		J0119_1_sub sub=new J0119_1_sub();
		
		String name=sub.getName();
		System.out.println("name: "+name);
		
		int point=sub.getPoint();
		System.out.println("point: "+point);
		
		String kor=sub.getKor();
		System.out.println("kor: "+kor);
		
		int eng=sub.getEng();
		System.out.println("eng: "+eng);
		
		boolean tr=sub.getTrue();
		System.out.println("true: "+tr);
		
		String noodle=sub.getNoodle(200);
		System.out.println("noodle: "+noodle);
		
		String pass=sub.getPass(45);
		System.out.println("result: "+pass);
			
	}

}
