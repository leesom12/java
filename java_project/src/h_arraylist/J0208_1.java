package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0208_1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArrayList<J0208_1_dto> dtos = new ArrayList<J0208_1_dto>();
		J0208_1_dao dao= new J0208_1_dao();
		
		System.out.print("몇 명??");
		int count= sc.nextInt();
		
		for(int k=0; k<count; k++) {
			System.out.print("학년?");
			String grade= sc.next();
			System.out.print("반?");
			String ban= sc.next();
			System.out.print("번호?");
			String beonho=sc.next();
			System.out.print("성명?");
			String name= sc.next();
			System.out.print("국어 점수?");
			int kor= sc.nextInt();
			System.out.print("영어 점수?");
			int eng= sc.nextInt();
			System.out.print("수학 점수?");
			int mat= sc.nextInt();
			
			int total= kor+eng+mat;
//			int rank= dao.getRank(dtos);
			
			J0208_1_dto dto= new J0208_1_dto(grade, ban, beonho, name, kor, eng, mat, total);
			dtos.add(dto);
		}
		
		dao.setPrint(dtos);
		
	}

}
