package n_exception;

public class J0213_2 {

	public static void main(String[] args) {
		String[] str= new String[2];
		str[0]="백";
		str[1]="이백";
		
		int kor=0;
		int eng=0;
		
		try {
			kor=Integer.parseInt(str[0]);
			eng=Integer.parseInt(str[2]);
		}catch(NumberFormatException e) {
			System.out.println("catch11");
		} catch(ArrayIndexOutOfBoundsException a){
			System.out.println("catch22");
		}
		
		System.out.println("kor: "+kor);
		System.out.println("eng: "+eng);
		System.out.println("종료");

	}

}
