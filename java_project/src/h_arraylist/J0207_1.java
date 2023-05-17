package h_arraylist;

import java.util.ArrayList;

public class J0207_1 {

	public static void main(String[] args) {
		ArrayList<J0207_1_dto> arr= new ArrayList<>();
		
		J0207_1_dto dto1= new J0207_1_dto("101", "홍길동", "대전", 25);
		J0207_1_dto dto2= new J0207_1_dto("201", "이상화", "서울", 32);
		
		arr.add(dto1);
		arr.add(dto2);
		arr.add(new J0207_1_dto("301", "김민식", "부산", 35));
		
		for(int k=0; k<arr.size(); k++) {
			System.out.print(arr.get(k).getId()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getArea()+"\t");
			System.out.print(arr.get(k).getAge()+"\n");
		}

	}

}
