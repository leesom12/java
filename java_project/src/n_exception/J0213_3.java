package n_exception;

public class J0213_3 {

	public static void main(String[] args) {
		String[] str= new String[2];
		str[0]="100";
		str[1]="이백";
		
		int kor=0;
		int eng=0;
		int total=0;
		
		try {
			kor=Integer.parseInt(str[0]);
			total+=kor;
			eng=Integer.parseInt(str[2]);
			total+=eng;
		}catch(Exception e) {
			System.out.println("catch11");
			total=0;
		} 
		
		System.out.println("kor: "+kor);
		System.out.println("eng: "+eng);
		System.out.println("total: "+total);
		System.out.println("종료");

	}

}
