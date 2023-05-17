package b_if;

import java.util.Scanner;

public class J0111_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("계절? 봄 1, 여름 2, 가을 3, 겨울 4");
		String season=sc.next();
		
		String month="";
		if(season.equals("1")) {
			month="3월~5월";
		} else if(season.equals("2")) {
			month="6월~8월";
		} else if(season.equals("3")) {
			month="9월~11월";
		} else if(season.equals("4")) {
			month="12월~2월";
		} else month="입력 오류";
		System.out.println(month);
	}

}
