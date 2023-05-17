package c_switch;

import java.util.Scanner;

public class J0111_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇 월 입니까?");
		String mon = sc.next();
		
		int month=Integer.parseInt(mon);
		String sea="";
		switch(month) {
		case 1: case 2: case 12: 
			sea="겨울"; 
			break;
		case 3: case 4: case 5: 
			sea="봄"; 
			break;
		case 6: case 7: case 8:
			sea="여름"; 
			break;
		case 9: case 10: case 11:
			sea="가을"; 
			break;
		default: sea="입력오류";
		}
		System.out.println("계절 3: "+sea);
		
		String season="";
		switch(mon) {
			case"1": case"2": case"12":
				season="겨울"; 
				break;
			case"3": case"4": case"5":
				season="봄"; 
				break;
			case"6": case"7": case"8":
				season="여름"; 
				break;
			case"9": case"10": case"11":
				season="가을"; 
				break;
			default: season="입력오류";
		}
		System.out.println("계절1: "+season);
		
		String season2="";
		if(mon.equals("1") || mon.equals("2") || mon.equals("12")) {
			season2="겨울";
		} else if(mon.equals("3") || mon.equals("4") || mon.equals("5")) {
			season2="봄";
		} else if(mon.equals("6") || mon.equals("7")|| mon.equals("8")) {
			season2="여름";
		} else if(mon.equals("9")||mon.equals("10")||mon.equals("11")){
			season2="가을";
		} else season2="입력오류";
		System.out.println("계절2: "+season2);		
			
	}

}
