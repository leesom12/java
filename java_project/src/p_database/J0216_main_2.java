package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0216_main_2{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		J0216_student_dao_2 dao = new J0216_student_dao_2();
		ArrayList<J0216_student_dto_2> dtos = 
				          dao.getStudentList();
		dao.resultPrint(dtos);
		
		int gubun = 0;
		do{
			System.out.print("검색   전체[1], ID[2], 성명:[3], 등록[4], 수정[5], 삭제[6], 종료[0]?");
			gubun = sc.nextInt();
			
			if(gubun == 1){
				ArrayList<J0216_student_dto_2> arr =
					         dao.getSearchList("id","");
				dao.resultPrint(arr);
				
			}else if(gubun == 2){
				System.out.print("검색 ID?");
				String id = sc.next();
				ArrayList<J0216_student_dto_2> arr =
						    dao.getSearchList("id",id);
				dao.resultPrint(arr);
				
			}else if(gubun == 3) {
				System.out.print("검색 성명?");
				String name = sc.next();
				ArrayList<J0216_student_dto_2> arr =
					       dao.getSearchList("name",name);	
				dao.resultPrint(arr);
				
			}else if(gubun == 4) {
				System.out.print("ID?");
				String id = sc.next();
				
				if(id.length() != 3) {
					System.out.println("id 입력오류. 3자리 입력!");
					continue;
				}
				
				System.out.print("성명?");
				String name = sc.next();
				
				if(name.length() > 6) {
					System.out.println("name 입력 오류. 6자 이내 입력!");
					continue;
				}
				
				int kor=0, eng=0, mat=0;
				System.out.print("국어점수?");
				try {
					kor= sc.nextInt();
				} catch(Exception e) {
					kor=-1;
				} finally {
					
				}
				
				if(kor>100 || kor<0) {
					System.out.println("점수 입력 오류! 0~100 사이");
					continue;
				}
				
				System.out.print("영어점수?");
				try {
					eng= sc.nextInt();
				} catch(Exception e) {
					eng=-1;
				} finally {
					
				}
				
				if(eng>100 || eng<0) {
					System.out.println("점수 입력 오류! 0~100 사이");
					continue;
				}
				
				System.out.print("수학점수?");
				try {
					mat= sc.nextInt();
				} catch(Exception e) {
					mat=-1;
				} finally {
					
				}
				
				if(mat>100 || mat<0) {
					System.out.println("점수 입력 오류! 0~100 사이");
					continue;
				}
				
				
				int total = dao.getTotal(kor,eng,mat);
				String result = dao.getResult(total);
				
				J0216_student_dto_2 dto = 
					new J0216_student_dto_2(id, name, kor, eng, mat, total, result);

				int yn = dao.saveStudent(dto);
				
				if(yn == 1) System.out.println("등록되었습니다.");
				else System.out.println("등록실패~");
				
			
			} else if(gubun == 5) {
				System.out.print("수정할 id?");
				String id= sc.next();
				
				if(id.length() != 3) {
					System.out.println("id 3자리 입력!!");
				} else {
					J0216_student_dto_2 dto= dao.getStudentInfo(id);
					if(dto == null) {
						System.out.println("id 정보없음");
					}else {
						ArrayList<J0216_student_dto_2> arr= new ArrayList<J0216_student_dto_2>();
						arr.add(dto);
						dao.resultPrint(arr);
						
						System.out.print("수정하겠습니까? 예[y], 아니오[n]");
						String yn=sc.next();
						
						if(yn.equals("y")||yn.equals("Y")||yn.equals("ㅛ")) {
							System.out.print("성명?");
							String name=sc.next();
							System.out.print("국어점수?");
							int kor= sc.nextInt();
							System.out.print("영어점수?");
							int eng= sc.nextInt();
							System.out.print("수학점수?");
							int mat=sc.nextInt();
							int total=dao.getTotal(kor, eng, mat);
							String result=dao.getResult(total);
							
							J0216_student_dto_2 dto2= new J0216_student_dto_2(id, name, kor, eng, mat, total, result);
							int updateResult = dao.updateStudent(dto2);
							
							if(updateResult == 1) System.out.println("수정되었습니다.");
							else System.out.println("수정 실패!!");
							
						}
					}
				}
			} else if(gubun == 6) {
				System.out.print("삭제할 id?");
				String id= sc.next();
				J0216_student_dto_2 dto= dao.getStudentInfo(id);
				if(dto == null) {
					System.out.println("존재하지 않는 id");
				} else {
					ArrayList<J0216_student_dto_2> arr= new ArrayList<J0216_student_dto_2>();
					arr.add(dto);
					dao.resultPrint(arr);
					
					System.out.print("삭제하시겠습니까? 예[y], 아니오[n]");
					String yn= sc.next();
					
					if(yn.equals("y")||yn.equals("Y")||yn.equals("ㅛ")) {
						int deleteResult = dao.deleteStudent(id);
						
						if(deleteResult == 1) System.out.println("삭제되었습니다.");
						else System.out.println("삭제 실패!!");
					}
				}
			}
			
		}while(gubun != 0);
		
		System.out.println("종료~~~");
		
		
	
		
	}

}










