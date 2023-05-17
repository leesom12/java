package n_exception;

public class J0213_1 {

	public static void main(String[] args) {
		System.out.println("시스템 시작");
		String kor= "100";
		int korNum=0;
		try {
			//오류 발생하면 멈춤
			System.out.println("try 000");
			korNum=Integer.parseInt(kor);
			System.out.println("try 111");
		}catch(Exception e) {
			//오류 발생하면 실행
			System.out.println("오류 발생");
		}finally {
			//오류가 발생하든 안하든 무조건 실행
			System.out.println("finally");
		}
		System.out.println("korNum: "+korNum);
		System.out.println("시스템 종료");

	}

}
