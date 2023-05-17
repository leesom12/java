package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0222_이소민_employee {

	public static void main(String[] args) {
		J0222_이소민_employee_dao dao= new J0222_이소민_employee_dao();
		Scanner sc= new Scanner(System.in);
		
		ArrayList<String> arr= dao.columnUpdate();
		System.out.println("arr: "+arr);
		
		int gubun=0;
		do {
			System.out.print("조회[1], 등록[2], 수정[3], 삭제[4], 종료[0]");
			gubun= sc.nextInt();
			
			//조회
			if(gubun == 1) {
				System.out.print("조회? 전체[A], 사번[I], 성명[N], 부서[D], 직급[R]");
				String choose = sc.next(); 
				if(choose.equals("A") || choose.equals("a") || choose.equals("ㅁ")) {
					ArrayList<J0222_이소민_employee_dto> dtos= dao.searchEmployee("id","");
					dao.resultPrint(dtos);
				}else if(choose.equals("I") || choose.equals("i") || choose.equals("ㅑ")) {
					System.out.print("검색할 사번?");
					String id= sc.next();
					ArrayList<J0222_이소민_employee_dto> dtos= dao.searchEmployee("id",id);
					dao.resultPrint(dtos);
				}else if(choose.equals("N") || choose.equals("n") || choose.equals("ㅜ")) {
					System.out.print("검색할 성명?");
					String name= sc.next();
					ArrayList<J0222_이소민_employee_dto> dtos= dao.searchEmployee("name",name);
					dao.resultPrint(dtos);
				}else if(choose.equals("D") || choose.equals("d") || choose.equals("ㅇ")) {
					System.out.print("검색할 부서? 총무[10], 인사[20], 영업[30], 재무[40]");
					String depart= sc.next();
					ArrayList<J0222_이소민_employee_dto> dtos= dao.searchEmployee("depart",depart);
					dao.resultPrint(dtos);
				}else if(choose.equals("R") || choose.equals("r") || choose.equals("ㄱ")){
					System.out.println("검색할 직급? 사원[A], 대리[B], 과장[C], 부장[D]");
					String rank= sc.next();
					if(rank.equals("a")||rank.equals("ㅁ")) rank="A";
					else if(rank.equals("b")||rank.equals("ㅠ")) rank="B";
					else if(rank.equals("c")||rank.equals("ㅊ")) rank="C";
					else if(rank.equals("d")||rank.equals("ㅇ")) rank="D";
					else System.out.println("입력오류~");
					ArrayList<J0222_이소민_employee_dto> dtos= dao.searchEmployee("rank", rank);
					dao.resultPrint(dtos);
				}else {
					System.out.println("입력 오류!!");
					continue;
				}
				
			
			//등록
			}else if(gubun == 2) {
				System.out.print("사번?");
				String id= sc.next();
				if(id.length() != 3) {
					System.out.println("3자리의 사번으로 입력하세요");
					continue;
				}
				
				int count = dao.checkId(id);
				if(count != 0) {
					System.out.println("중복된 ID");
					continue;
				}
				
				System.out.print("성함?");
				String name= sc.next();
				System.out.print("부서? 총무[10], 인사[20], 영업[30], 재무[40]");
				String depart= sc.next();
				System.out.print("직급? 사원[A], 대리[B], 과장[C], 부장[D]");
				String rank= sc.next();
				if(rank.equals("a")||rank.equals("ㅁ")) rank="A";
				else if(rank.equals("b")||rank.equals("ㅠ")) rank="B";
				else if(rank.equals("c")||rank.equals("ㅊ")) rank="C";
				else if(rank.equals("d")||rank.equals("ㅇ")) rank="D";
				else System.out.println("입력오류~");
				
				System.out.print("나이?");
				int age = sc.nextInt();
				
				J0222_이소민_employee_dto dto2= new J0222_이소민_employee_dto(id, name, depart, rank, age);
				int result= dao.employeeSave(dto2);
				
				if(result == 1) System.out.println("등록 성공~");
				else System.out.println("등록 실패!");
				
			//수정
			}else if(gubun == 3) {
				System.out.print("수정할 사번?");
				String id= sc.next();
				
				if(id.length() != 3) {
					System.out.println("3자리의 사번으로 입력하세요");
				} else {
					J0222_이소민_employee_dto dto= dao.getEmployee(id);
					if(dto == null) {
						System.out.println("없는 정보입니다");
					} else {
						ArrayList<J0222_이소민_employee_dto> dtos = new ArrayList<J0222_이소민_employee_dto>();
						dtos.add(dto);
						dao.resultPrint(dtos);
						
						System.out.println("수정하겠습니까? 예[y], 아니오[n]");
						String yn= sc.next();
						
						if(yn.equals("y")||yn.equals("Y")||yn.equals("ㅛ")) {
							System.out.print("수정 범위? 전체[1], 성명[2], 부서[3], 직급[4], 나이[5]");
							int choose= sc.nextInt();
							
							String name= dto.getName();
							String depart= dao.getCode("depart", id);
							String rank= dao.getCode("rank", id);
							int age= dto.getAge();
							
							if(choose == 1) {
								System.out.print("이름?");
								name= sc.next();
								System.out.print("부서? 총무[10], 인사[20], 영업[30], 재무[40]");
								depart= sc.next();
								System.out.print("직위? 사원[A], 대리[B], 과장[C], 부장[D]");
								rank= sc.next();
								if(rank.equals("a")||rank.equals("ㅁ")) rank="A";
								else if(rank.equals("b")||rank.equals("ㅠ")) rank="B";
								else if(rank.equals("c")||rank.equals("ㅊ")) rank="C";
								else if(rank.equals("d")||rank.equals("ㅇ")) rank="D";
								else System.out.println("입력오류~");
								System.out.print("나이?");
								age= sc.nextInt();
							}else if(choose == 2) {
								System.out.print("이름?");
								name= sc.next();
							}else if(choose == 3) {
								System.out.print("부서? 총무[10], 인사[20], 영업[30], 재무[40]");
								depart= sc.next();
							}else if(choose == 4) {
								System.out.print("직위? 사원[A], 대리[B], 과장[C], 부장[D]");
								rank= sc.next();
								if(rank.equals("a")||rank.equals("ㅁ")) rank="A";
								else if(rank.equals("b")||rank.equals("ㅠ")) rank="B";
								else if(rank.equals("c")||rank.equals("ㅊ")) rank="C";
								else if(rank.equals("d")||rank.equals("ㅇ")) rank="D";
								else System.out.println("입력오류~");
							}else if(choose == 5) {
								System.out.print("나이?");
								age= sc.nextInt();
							}else System.out.println("입력오류~");
							
							dto= new J0222_이소민_employee_dto(id, name, depart, rank, age);
							int updateResult = dao.updateEmployee(dto);
							
							if(updateResult == 1) System.out.println("수정 성공!");
							else System.out.println("수정 실패~");
						}
						
						
					}
				}
				
			//삭제
			}else if(gubun == 4) {
				System.out.print("삭제할 사번?");
				String id= sc.next();
				
				if(id.length() != 3) {
					System.out.println("3자리의 사번으로 입력하세요");
					continue;
				} else {
					J0222_이소민_employee_dto dto = dao.getEmployee(id);
					if(dto == null) {
						System.out.println("존재하지 않는 사번입니다");
					}else {
						ArrayList<J0222_이소민_employee_dto> dtos = new ArrayList<J0222_이소민_employee_dto>();
						dtos.add(dto);
						dao.resultPrint(dtos);
						
						System.out.println("삭제하시겠습니까? 예[y], 아니오[n]");
						String yn= sc.next();
						
						if(yn.equals("y")||yn.equals("Y")||yn.equals("ㅛ")) {
							int deleteResult = dao.deleteEmployee(dto);
							
							if(deleteResult == 1) System.out.println("삭제 성공!");
							else System.out.println("삭제 실패~");
						}
					}
				}
			}
		} while(gubun != 0);
		System.out.println("종료");
	}

}
