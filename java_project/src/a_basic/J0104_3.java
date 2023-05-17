package a_basic;

public class J0104_3 {

	public static void main(String[] args) {
		int kor=85;
		int eng=70;
		int mat=60;
		int total=kor+eng+mat;
		double ave=total/3.0;		
		//int로 계산시 소수점 버려짐. double로 계산시 int 나누기 int(total/3) 하면 71.0 나옴. 둘 중 하나는 실수 타입이어야 소수점 나옴
		
		System.out.println("총점: "+total);
		System.out.println("평균: "+ave);

	}

}
