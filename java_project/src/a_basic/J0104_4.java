package a_basic;

import java.util.Scanner;

public class J0104_4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("성명?");
		String name=sc.next();	
		//변수명.method
		System.out.println("성명: "+name);
		
		System.out.print("국어점수?");
		int kor=sc.nextInt();
		System.out.print("영어점수?");
		int eng=sc.nextInt();
		int total=kor+eng;
		
		System.out.println("총점: "+total);
		
	}

}
