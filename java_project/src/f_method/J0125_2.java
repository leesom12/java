package f_method;

import java.util.Scanner;

public class J0125_2 {

	public static void main(String[] args) {
		J0125_2_sub sub=new J0125_2_sub();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("국어 점수?");
		int kor= sc.nextInt();
		System.out.print("영어 점수?");
		int eng = sc.nextInt();
		System.out.print("수학 점수?");
		int mat= sc.nextInt();
		
		int total= sub.getTotal(kor, eng, mat);
		double ave= sub.getAve(total, 3);
		String result= sub.getResult(ave);
		
		System.out.println("total: "+ total);
		System.out.println("ave: "+ ave);
		System.out.println("result: "+result);

	}

}
