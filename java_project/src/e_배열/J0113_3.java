package e_배열;

public class J0113_3 {

	public static void main(String[] args) {
		int[] arr = {12,45,14,75,86,49,12,56,45,85,23,62,45,78,95,45,26,78,64,68,54,55,85};
		
		int total=0;
		int num=0;
		int tot=0;
		for(int k=0; k<arr.length; k++) {
			total+=arr[k];
			if(arr[k]<50) {
				num+=1;
				tot+=arr[k];
			}
		}
		System.out.println("total: "+total);
		System.out.println("50보다 작은 수: "+num+"개");
		System.out.println("50이하 총 누적: "+tot);
	}

}
