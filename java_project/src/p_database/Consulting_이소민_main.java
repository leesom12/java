package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class Consulting_이소민_main {

	public static void main(String[] args) {		
		
		Cstudent_이소민_dao s_dao= new Cstudent_이소민_dao();
		Cmentor_이소민_dao m_dao= new Cmentor_이소민_dao();
		Consulting_이소민_dao c_dao= new Consulting_이소민_dao();
		Scanner sc= new Scanner(System.in);
		String gubun = "";
		
		do {
			System.out.print("학생관리[S], 멘토관리[M], 상담관리[C], 종료[Q]");
			gubun= sc.next();
			
			//학생관리
			if(gubun.equalsIgnoreCase("s") || gubun.equals("ㄴ")) {
				System.out.print("검색? 조회[1], 등록[2], 수정[3], 삭제[4] 뒤로[0]");
				int choose = sc.nextInt();
				
				//학생 조회
				if(choose == 1) {
					System.out.print("전체[1], 학번[2], 성명[3]");
					int select = sc.nextInt();
					if(select == 1) {
						ArrayList<Cstudent_이소민_dto> dtos = s_dao.getStudentList("id","");
						s_dao.getStudentPrint(dtos);
					}else if(select ==2) {
						System.out.print("검색할 학번?");
						String id= sc.next();
						id=id.toUpperCase();
						ArrayList<Cstudent_이소민_dto> dtos = s_dao.getStudentList("id",id);
						s_dao.getStudentPrint(dtos);
					}else if(select==3) {
						System.out.print("검색할 이름?");
						String name= sc.next();
						ArrayList<Cstudent_이소민_dto> dtos = s_dao.getStudentList("name",name);
						s_dao.getStudentPrint(dtos);
					}
				//학생 등록
				}else if(choose == 2) {
					System.out.print("등록할 ID?");
					String id= sc.next();
					id=id.toUpperCase();
					
					if(id.length() != 4) {
						System.out.println("s를 포함한 4자리로 입력!");
					} else {
						int count = s_dao.checkStudentId(id);
						if(count != 0) {
							System.out.println("중복된 id");
						}else {
							System.out.print("성명?");
							String name= sc.next();
							System.out.print("나이?");
							int age= sc.nextInt();
							
							Cstudent_이소민_dto dto= new Cstudent_이소민_dto(id, name, age);
							int result= s_dao.saveStudent(dto);
							if(result == 1) System.out.println("등록 성공~");
							else System.out.println("등록 실패!");
						}
					}
					
				//학생 수정	
				}else if(choose == 3) {
					System.out.print("수정할 ID?");
					String id= sc.next();
					
					int count= s_dao.checkStudentId(id);
					if(count == 0) {
						System.out.println("존재하지 않는 ID");
					}else {
						ArrayList<Cstudent_이소민_dto> dtos= s_dao.getStudentList("id",id);
						s_dao.getStudentPrint(dtos);
						
						System.out.print("수정하시겠습니까? 예[y], 아니오[n]");
						String yn= sc.next();
						
						if(yn.equalsIgnoreCase("y") || yn.equals("ㅛ")) {
							System.out.print("성명?");
							String name= sc.next();
							System.out.print("나이?");
							int age= sc.nextInt();
							
							Cstudent_이소민_dto dto = new Cstudent_이소민_dto(id, name, age);
							int result= s_dao.updateStudent(dto);
							if (result == 1) System.out.println("수정 성공~");
							else System.out.println("수정 실패!");
						}
					}
					
				//학생 삭제	
				}else if(choose == 4) {
					System.out.print("삭제할 ID?");
					String id= sc.next();
					id=id.toUpperCase();
					
					int count = s_dao.checkStudentId(id);
					if(count == 0) {
						System.out.println("존재하지 않는 ID");
					}else {
						int count2= c_dao.checkNo("sid", id);
						if(count2 != 0) {
							System.out.println("상담내역이 있어 삭제할 수 없습니다.");
						} else {
							ArrayList<Cstudent_이소민_dto> dtos= s_dao.getStudentList("id",id);
							s_dao.getStudentPrint(dtos);
							
							System.out.print("삭제하시겠습니까? 예[y], 아니오[n]");
							String yn= sc.next();
							
							if(yn.equalsIgnoreCase("y") || yn.equals("ㅛ")) {
								int result= s_dao.deleteStudent(id);
								if(result == 1) System.out.println("삭제 성공~");
								else System.out.println("삭제 실패!");
							}
						}
					}
					
				//뒤로가기	
				}else if(choose == 0) {
					continue;
				}
				
			//멘토관리
			}else if(gubun.equalsIgnoreCase("m") || gubun.equals("ㅡ")) {
				System.out.print("검색? 조회[1], 등록[2], 수정[3], 삭제[4] 뒤로[0]");
				int choose = sc.nextInt();
				
				//멘토 조회
				if(choose == 1) {
					System.out.print("전체[1], 번호[2], 성명[3]");
					int select = sc.nextInt();
					if(select == 1) {
						ArrayList<Cmentor_이소민_dto> dtos = m_dao.getMentorList("id","");
						m_dao.mentorPrint(dtos);
					}else if(select ==2) {
						System.out.print("검색할 번호?");
						String id= sc.next();
						id=id.toUpperCase();
						ArrayList<Cmentor_이소민_dto> dtos = m_dao.getMentorList("id", id);
						m_dao.mentorPrint(dtos);
					}else if(select==3) {
						System.out.print("검색할 이름?");
						String name= sc.next();
						ArrayList<Cmentor_이소민_dto> dtos = m_dao.getMentorList("name", name);
						m_dao.mentorPrint(dtos);
					}
					
				//멘토 등록	
				}else if(choose == 2) {
					System.out.print("등록할 ID?");
					String id= sc.next();
					id= id.toUpperCase();
					
					if(id.length() != 4) {
						System.out.println("m을 포함한 4자리로 입력!");
					}else {
						int count = m_dao.checkMentorId(id);
						if(count != 0) {
							System.out.println("이미 존재하는 ID");
						}else {
							System.out.print("성명?");
							String name= sc.next();
							
							Cmentor_이소민_dto dto= new Cmentor_이소민_dto(id, name);
							int result= m_dao.saveMentor(dto);
							if(result == 1) System.out.println("등록 성공~");
							else System.out.println("등록 실패!");
						}
					}
				//멘토 수정	
				}else if(choose == 3) {
					System.out.print("수정할 ID?");
					String id= sc.next();
					id=id.toUpperCase();
					
					int count= m_dao.checkMentorId(id);
					if(count == 0) {
						System.out.println("존재하지 않는  ID");
					}else {
						ArrayList<Cmentor_이소민_dto> dtos = m_dao.getMentorList("id",id);
						m_dao.mentorPrint(dtos);
						System.out.print("수정하시겠습니까? 예[y], 아니오[n]");
						String yn= sc.next();
						
						if(yn.equalsIgnoreCase("y")||yn.equals("ㅛ")) {
							System.out.print("성명?");
							String name= sc.next();
							
							Cmentor_이소민_dto dto= new Cmentor_이소민_dto(id, name);
							int result= m_dao.updateMentor(dto);
							if(result == 1) System.out.println("수정 성공~");
							else System.out.println("수정 실패!");
						}
					}
				//멘토 삭제	
				}else if(choose == 4) {
					System.out.print("삭제할 ID?");
					String id= sc.next();
					id= id.toUpperCase();
					
					int count = m_dao.checkMentorId(id);
					if(count == 0) {
						System.out.println("존재하지 않는 ID");
					} else {
						int count2= c_dao.checkNo("mid", id);
						if(count2 != 0) {
							System.out.println("상담내역이 존재해 삭제할 수 없습니다.");
						}else {
							ArrayList<Cmentor_이소민_dto> dtos= m_dao.getMentorList("id",id);
							m_dao.mentorPrint(dtos);
							
							System.out.print("삭제하시겠습니까? 예[y], 아니오[n]");
							String yn= sc.next();
							if(yn.equalsIgnoreCase("y")||yn.equals("ㅛ")) {
								int result= m_dao.deleteMentor(id);
								if(result == 1) System.out.println("삭제 성공~");
								else System.out.println("삭제 실패!");
							}
						}
					}
				//뒤로 가기	
				}else if(choose == 0) {
					continue;
				}
				
			//상담관리
			}else if(gubun.equalsIgnoreCase("c") || gubun.equals("ㅊ")) {
				System.out.print("검색? 조회[1], 등록[2], 수정[3], 삭제[4] 뒤로[0]");
				int choose = sc.nextInt();
				
				//상담조회
				if(choose == 1) {
					System.out.print("전체[1], 상담번호[2], 학생[3], 멘토[4]");
					int c= sc.nextInt();
					if(c==1) {
						ArrayList<Consulting_이소민_dto> dtos = c_dao.getConsultingList("no","");
						c_dao.getConsultPrint(dtos);
					}else if(c==2) {
						System.out.print("검색할 상담번호?");
						String no= sc.next();
						no= no.toUpperCase();
						ArrayList<Consulting_이소민_dto> dtos = c_dao.getConsultingList("no",no);
						c_dao.getConsultPrint(dtos);
					}else if(c==3) {
						System.out.print("검색할 학생 번호?");
						String sid= sc.next();
						sid= sid.toUpperCase();
						ArrayList<Consulting_이소민_dto> dtos = c_dao.getConsultingList("sid",sid);
						c_dao.getConsultPrint(dtos);
					}else if(c==4) {
						System.out.print("검색할 멘토 번호?");
						String mid= sc.next();
						mid= mid.toUpperCase();
						ArrayList<Consulting_이소민_dto> dtos = c_dao.getConsultingList("mid",mid);
						c_dao.getConsultPrint(dtos);
					}
		
				//상담 등록	
				}else if(choose ==2) {
					System.out.print("등록할 번호?");
					String no= sc.next();
					no= no.toUpperCase();
					if(no.length() != 4) {
						System.out.println("C를 포함한 4자리의 번호로 입력하세요");
						continue;
					}
					int count= c_dao.checkNo("no",no);
					if(count != 0) {
						System.out.println("이미 존재하는 상담번호입니다");
					}else {
						System.out.print("등록할 학생 번호?");
						String sid= sc.next();
						sid= sid.toUpperCase();
						int s = s_dao.checkStudentId(sid);
						if(s==0) {
							System.out.println("존재하지 않는 학생!");
						} else {
							System.out.print("등록할 멘토 번호?");
							String mid= sc.next();
							mid= mid.toUpperCase();
							int m= m_dao.checkMentorId(mid);
							if(m==0) {
								System.out.println("존재하지 않는 멘토 번호!");
							}else {
								System.out.print("상담일? [yymmdd] 형식으로 입력");
								String cdate=sc.next();
								System.out.print("상담내용?");
								String content=sc.next();
								Consulting_이소민_dto dto= new Consulting_이소민_dto(no, sid, mid, cdate, content);
								int result = c_dao.saveConsult(dto);
								if(result ==1) System.out.println("등록 성공~");
								else System.out.println("등록 실패!");
							}
						}
						
					}
					
				//상담 수정	
				}else if(choose ==3) {
					System.out.print("수정할 번호?");
					String no= sc.next();
					no= no.toUpperCase();
					
					int count= c_dao.checkNo("no",no);
					if(count ==0) {
						System.out.println("존재하지 않는 상담번호!");
					}else {
						ArrayList<Consulting_이소민_dto> dtos= c_dao.getConsultingList("no", no);
						c_dao.getConsultPrint(dtos);
						System.out.print("수정하시겠습니까? 예[y], 아니오[n]");
						String yn= sc.next();
						if(yn.equalsIgnoreCase("y")||yn.equals("ㅛ")) {
							
							String sid= dtos.get(0).getSid();
							String mid= dtos.get(0).getMid();
							String cdate= dtos.get(0).getDate();
							String content=dtos.get(0).getContent();
							
							System.out.print("수정 범위? 전체[1], 학생[2], 멘토[3], 상담일[4], 상담내용[5]");
							int c= sc.nextInt();
							if(c == 1) {
								System.out.print("학생 번호?");
								sid= sc.next();
								sid= sid.toUpperCase();
								int s= s_dao.checkStudentId(sid);
								if(s==0) {
									System.out.println("존재하지 않는 학생 번호!");
									continue;
								} else {
									System.out.print("멘토 번호?");
									mid= sc.next();
									mid=mid.toUpperCase();
									int m= m_dao.checkMentorId(mid);
									if(m==0) {
										System.out.println("존재하지 않는 멘토 번호!");
										continue;
									} else {
										System.out.print("상담일? [yymmdd]");
										cdate= sc.next();
										System.out.print("상담내용?");
										content= sc.next();
									}
								}
							}else if(c == 2) {
								System.out.print("학생 번호?");
								sid= sc.next();
								sid= sid.toUpperCase();
								int s= s_dao.checkStudentId(sid);
								if(s==0) {
									System.out.println("존재하지 않는 학생 번호!");
									continue;
								}
							}else if(c == 3) {
								System.out.print("멘토 번호?");
								mid= sc.next();
								mid=mid.toUpperCase();
								int m= m_dao.checkMentorId(mid);
								if(m==0) {
									System.out.println("존재하지 않는 멘토 번호!");
									continue;
								}
							}else if(c == 4) {
								System.out.print("상담일? [yymmdd]");
								cdate= sc.next();
							}else if(c == 5) {
								System.out.print("상담내용?");
								content= sc.next();
							}else System.out.println("입력 오류!!");
							
							Consulting_이소민_dto dto= new Consulting_이소민_dto(no, sid, mid, cdate, content);
							int result= c_dao.updateConsult(dto);
							if(result == 1) System.out.println("수정 성공~");
							else System.out.println("수정 실패!");
						}
					}
					
				//상담 삭제	
				}else if(choose ==4) {
					System.out.print("삭제할 상담 번호?");
					String no= sc.next();
					no=no.toUpperCase();
					
					int count= c_dao.checkNo("no",no);
					if(count == 0) {
						System.out.println("존재하지 않는 상담 번호!!");
					}else {
						ArrayList<Consulting_이소민_dto> dtos= c_dao.getConsultingList("no", no);
						c_dao.getConsultPrint(dtos);
						System.out.print("삭제하시겠습니까? 예[y], 아니오[n]");
						String yn = sc.next();
						if(yn.equalsIgnoreCase("y")||yn.equals("ㅛ")) {
							int result= c_dao.deleteConsult(no);
							if(result==1)System.out.println("삭제 성공~");
							else System.out.println("삭제 실패!");
						}
					}
					
				//뒤로가기	
				}else if(choose ==0) {
					continue;
				}
			}
		}while(!gubun.equalsIgnoreCase("q") && !gubun.equals("ㅂ"));
		System.out.println("system 종료");

	}

}
