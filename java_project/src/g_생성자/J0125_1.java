package g_생성자;

public class J0125_1 {

	public static void main(String[] args) {
		J0125_1_sub sub= new J0125_1_sub();
		
		int kor= sub.getKor();
		System.out.println("kor: "+kor);
		sub.setKor(200);
		kor = sub.getKor();
		System.out.println("kor: "+kor);
		
		sub.setName("이상화");
		String name=sub.getName();
		System.out.println("name: "+name);
		sub.setName("홍길동");
		name=sub.getName();
		System.out.println("name: "+name);
		
		sub.setAve(80.7);
		double ave=sub.getAve();
		System.out.println("ave: "+ave);

	}

}
