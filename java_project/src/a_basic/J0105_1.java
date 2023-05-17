package a_basic;

import java.util.Scanner;

public class J0105_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("성명?");
		String name=sc.next();
		System.out.print("지역?");
		String area=sc.next();
		System.out.print("나이?");
		String age=sc.next();
		System.out.println("성명: "+name);
		System.out.println("지역: "+area);
		System.out.println("나이: "+age);

	}

}
