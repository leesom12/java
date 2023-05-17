package b_if;

import java.util.Scanner;

public class J0106_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("남/여? ");
		String gender=sc.next();
		System.out.print("나이?");
		int age=sc.nextInt();
		
		if(gender.equals("남") && age>=20) {
			System.out.println("100만원");
		} 
		else if(gender.equals("남") || age>=20) {
			System.out.println("50만원");
		}
	
	}
}

