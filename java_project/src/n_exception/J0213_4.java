package n_exception;

import java.util.Scanner;

public class J0213_4 {

	public static void main(String[] args) {
		J0213_4_sub sub= new J0213_4_sub();
		Scanner sc= new Scanner(System.in);
	
//		System.out.print("국어 점수?");
//		String kor=sc.next();
//		System.out.print("영어 점수?");
//		String eng=sc.next();
		
		String kor="80";
		String eng="90";
		
		int total=sub.getTotal(kor, eng);
		System.out.println("total: "+total);
		
		int ave=0;
		try {
			ave = sub.getAve(total,"2kk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("ave: "+ave);
		System.out.println("종료");

	}

}
