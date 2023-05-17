package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0221_이소민_member {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		J0221_이소민_dao dao= new J0221_이소민_dao();
		
		int gubun=0;
		
		do {
			System.out.print("검색: 전체[1], 성명[2], 지역[3], 등록[4], 수정[5], 삭제[6], 종료[0]");
			gubun= sc.nextInt();
			
			//전체 검색
			if(gubun == 1) {
				ArrayList<J0221_이소민_dto> dtos = dao.searchInfo("id","");
				dao.setPrint(dtos);
			
			//성명 검색	
			} else if(gubun ==2) {
				System.out.print("검색할 이름?");
				String name= sc.next();
				ArrayList<J0221_이소민_dto> dtos = dao.searchInfo("name",name);
				dao.setPrint(dtos);
			
			//지역 검색	
			}else if(gubun ==3) {
				System.out.print("검색할 지역?");
				String area= sc.next();
				ArrayList<J0221_이소민_dto> dtos = dao.searchInfo("area",area);
				dao.setPrint(dtos);
			
			//등록	
			}else if(gubun == 4) {
				
				System.out.print("ID?");
				String id= sc.next();
				if(id.length() != 3) {
					System.out.println("id 입력 오류. 3자리로 입력!");
					continue;
				} 
				J0221_이소민_dto dtos= dao.getIdResult(id);
				if( dtos != null) {
					System.out.println("이미 존재하는 ID. 다시 입력!!");
					continue;
				}
				
				System.out.print("성명?");
				String name= sc.next();
				if(name.length() > 5) {
					System.out.println("성명 입력 오류. 5자 이내 입력!");
					continue;
				}
				
				System.out.print("지역?");
				String area= sc.next();
				if(area.length() > 5){
					System.out.println("지역 입력 오류. 5자 이내 입력!");
					continue;
				}
				
				System.out.print("나이?");
				int age= sc.nextInt();
				
				J0221_이소민_dto dto = new J0221_이소민_dto(id, name, area, age);
				int result= dao.saveInfo(dto);
				
				if(result ==1) System.out.println("등록 성공!");
				else System.out.println("등록 실패!");
			
			//수정	
			}else if(gubun == 5) {
				System.out.print("수정할 ID?");
				String id= sc.next();
				
				if(id.length() != 3) {
					System.out.println("id 입력 오류. 3자리로 입력!");
				} else {
					J0221_이소민_dto dtos= dao.getIdResult(id);
					if(dtos ==  null) {
						System.out.println("존재하지 않는 id");
					} else {
						ArrayList<J0221_이소민_dto> arr = new ArrayList<J0221_이소민_dto>();
						arr.add(dtos);
						dao.setPrint(arr);
						System.out.print("수정하겠습니까? 예[y], 아니오[n]");
						String yn= sc.next();
						
						if(yn.equals("y")||yn.equals("Y")||yn.equals("ㅛ")) {
							String name= dtos.getName();
							String area=dtos.getArea();
							int age= dtos.getAge();
							System.out.print("수정 범위? 전체[1], 이름[2], 지역[3], 나이[4]");
							int choose= sc.nextInt();
							if(choose == 1) {	//전체
								System.out.print("성명?");
								name= sc.next();
								System.out.print("지역?");
								area=sc.next();
								System.out.print("나이?");
								age=sc.nextInt();
							}else if(choose == 2) {		//이름
								System.out.print("성명?");
								name= sc.next();
							}else if(choose == 3) {		//지역
								System.out.print("지역?");
								area=sc.next();
							}else  if(choose == 4) {	//나이
								System.out.print("나이?");
								age=sc.nextInt();
							}else {
								System.out.println("입력 오류!");
								continue;
							}
							
							J0221_이소민_dto dto= new J0221_이소민_dto(id, name, area, age);
							int updateResult = dao.updateInfo(dto);
							
							if(updateResult == 1) System.out.println("수정 성공!");
							else System.out.println("수정 실패!");
						}
					}
				}
			
			//삭제	
			}else if(gubun == 6) {
				System.out.print("삭제할 ID?");
				String id= sc.next();
				
				if(id.length() != 3) {
					System.out.println("id 입력 오류. 3자리로 입력!");
				} else {
					J0221_이소민_dto dto= dao.getIdResult(id);
					if(dto == null) {
						System.out.println("존재하지 않는 id");
					} else {
						ArrayList<J0221_이소민_dto> arr = new ArrayList<J0221_이소민_dto>();
						arr.add(dto);
						dao.setPrint(arr);
						
						System.out.print("삭제하겠습니까? 예[y], 아니오[n]");
						String yn= sc.next();
						
						if(yn.equals("y")||yn.equals("Y")||yn.equals("ㅛ")) {
							int deleteResult = dao. deleteInfo(id);
							
							if (deleteResult == 1) System.out.println("삭제 성공!");
							else System.out.println("삭제 실패!");
						}	
					}
				}
			}
			
		} while(gubun != 0);
		System.out.println("종료");
	}

}
