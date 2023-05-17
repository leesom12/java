package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0207_3 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArrayList<J0207_3_dto> arr = new ArrayList<>();
		J0207_3_dao dao= new J0207_3_dao();
		
		System.out.print("몇 마리?");
		int count= sc.nextInt();
		
		for(int k=0; k<count; k++) {
			System.out.print("종류? [강아지:d, 고양이:c]");
			String kind = sc.next();
			System.out.print("동물 이름?");
			String name= sc.next();
			System.out.print("키?");
			int height= sc.nextInt();
			System.out.print("무게?");
			int weight= sc.nextInt();
			
			J0207_3_dto dto= new J0207_3_dto();
			
			dto.setKind(dao.getKind(kind));
			dto.setName(name);
			dto.setHeight(height);
			dto.setWeight(weight);
			
			arr.add(dto);
		}
		
		System.out.println("-----------------------------");
		System.out.println("종류"+"\t"+"이름"+"\t"+"키"+"\t"+"무게");
		System.out.println("-----------------------------");
		
		for(int k=0; k<arr.size(); k++ ) {
			System.out.print(arr.get(k).getKind()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getHeight()+"\t");
			System.out.print(arr.get(k).getWeight()+"\n");
		}
		
	}

}
