package b_if;

import java.util.Scanner;

public class J0111_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇 월 입니까?");
		String mon = sc.next();
		
		int month=Integer.parseInt(mon);
		String season="";
		
		if(month>12 || month<1 ) {
			season="계절 입력 오류";
		} else if (month>=3 && month<=5) {
			season="봄";
		} else if(month>=6 && month<=8){
			season="여름";
		} else if(month>=9 && month<=11) {
			season="가을";
		} else {
			season="겨울";
		}
		System.out.println(season);
	}

}
