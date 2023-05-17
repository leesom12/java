package b_if;

import java.util.Scanner;

public class J0109_4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("첫번째 수?");
		int first=sc.nextInt();
		System.out.print("연산자 입력?");
		String gubun=sc.next();
		System.out.print("두번째 수?");
		int second=sc.nextInt();
		
		int result=0;
		
		if (gubun.equals("+")) result=first+second;
		else if (gubun.equals("-")) result=first-second;
		else if (gubun.equals("*")) result=first*second;
		else if (gubun.equals("/")) result=first/second;
		else System.out.println("연산자 입력 오류");
		
		if(gubun.equals("+")||gubun.equals("-")||gubun.equals("*")||gubun.equals("/")) {
			System.out.println("결과: "+result);
		}
		
	}

}
