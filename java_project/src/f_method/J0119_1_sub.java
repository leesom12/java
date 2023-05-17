package f_method;

public class J0119_1_sub {
	
	//return타입 메소드명(){}
	String getName(){
		String name="홍길동";
		return name;		//return type에 맞는 결과를 return해줘야 함
	}
	
	//정수 100을 돌려줌
	int getPoint() {
		return 100;
	}
	
	String getKor() {
		return"90";
	}
	
	int getEng() {
		int eng=80;
		return eng;
	}
	
	boolean getTrue() {
		boolean tr=true;
		return tr;
	}
	
	String getNoodle(int gram) {		//int gram=매개변수
		String size="";
		if(gram==100) size="소";
		else if(gram==200) size="중";
		else if(gram==300) size="대";
		return size;
	}
	
	String getPass(int score) {
		String result="";
		if(score>=50) result="합격!";
		else result="불합격!";
		return result;
	}
}
