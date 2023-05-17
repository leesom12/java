package e_배열;

public class J0112_1 {

	public static void main(String[] args) {
		int a=10;
		String name="홍길동";
		
		int[] b= new int[4];
		b[0]=10;
		b[1]=20;
		b[2]=30;
		b[4]=40;
		
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
		b[1]=200;
		System.out.println(b[3]); // 값 설정 안해주면 초기값으로 설정
		
		String[] aa=new String[3];
		
	}

}
