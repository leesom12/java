package a_basic;

import java.util.Scanner;

public class J0105_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("성명?");
		String name=sc.next();
		System.out.print("총점?");
		int total=sc.nextInt();
		System.out.print("과목 수?");
		double sub=sc.nextDouble();
		double ave=total/sub;
		
		System.out.println("-------------------");
		System.out.println("성명: "+name);
		System.out.println("총점: "+total);
		System.out.println("평균: "+ave);
		System.out.println("-------------------");
	}

}
