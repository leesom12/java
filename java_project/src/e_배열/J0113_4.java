package e_배열;

public class J0113_4 {

	public static void main(String[] args) {
		int[] arr = {112,435,124,755,866,439,112,536,445,857,263,622,425,378,495,745,926,378,464,568,594,555,855,454,874,512,125,545,118,564};
		
		int count=0; //짝수의 개수
		int total=0; //홀수의 합
		for(int k=0; k<arr.length; k++) {
			if(arr[k]%2==0) {
				count+=1;
			} else total+=arr[k];
		}
		System.out.println("짝수 개수: "+count+"개");
		System.out.println("홀수 합: "+total);

	}

}
