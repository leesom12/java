package a_basic;

public class J0104_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//java변수: 정수
		byte num1=10;		// -128 ~ 127
		short num2=10;		// -32768 ~ 32767
		int num3=10;		// 약 +-21억까지. 정수의 대표 타입. 4바이트
		long num4=10l;		// 약 +-900경까지. 뒤에 l(L)붙여줌. 8바이트
		
		//java변수: 실수
		float num5=10.0f;	// 뒤에 f붙여줌 . 4바이트
		double num6=10.0;	// 대표 실수 타입. 8바이트
		
		//java변수: 논리
		boolean tf=true;	// true or false 두 가지만 대입 가능
		
		//java변수: 문자
		char cch='a';		// 한 글자만 입력 가능. 작은 따옴표 사용 . 2바이트
		
		//java변수: 문자열
		String str="홍길동입니다";		// 기본 변수 아님.
		System.out.println("성명 "+str);       // sysout + ctrl+spacebar 누르면 자동으로 변함
	}
	
}