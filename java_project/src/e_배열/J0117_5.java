package e_배열;

public class J0117_5 {

	public static void main(String[] args) {
		//String[] str= {"홍길동", "대전", "25"};
		String[][] str= new String[2][3]; //2차원 배열: [행][칸];
		str[0][0]="홍길동";
		str[0][1]="대전";
		str[0][2]="25";
		str[1][0]="이상화";
		str[1][1]="서울";
		str[1][2]="30";
		
		System.out.println(str.length); //str.length=2; 2차원 배열의 length는 행의 수를 의미(1차원 배열에서는 칸 수);
		//str[0]= 홍길동, 대전, 25; str[0]=str의 0번째 행에 있는 모든 1차원 배열;
		System.out.println("---------------------------");

		
		//int col=str[0].length;	//1차원 배열의 길이
		//System.out.println(col);
//		System.out.println(str[0][0]);
//		System.out.println(str[0][1]);
//		System.out.println(str[0][2]);
//		System.out.println(str[1][0]);
//		System.out.println(str[1][1]);
//		System.out.println(str[1][2]);
//		System.out.println("---------------------------");
		
		for(int k=0; k<str.length; k++) {
			for(int j=0; j<str[k].length; j++) System.out.print(str[k][j]+"\t");
			System.out.print("\n"); 
		}
	}

}
