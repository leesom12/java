package h_arraylist;

import java.util.ArrayList;

public class J0206_1 {

	public static void main(String[] args) {
		ArrayList<String> arr= new ArrayList<>();
		arr.add("홍길동");
		arr.add("이상화");
		arr.add("김민기");
//		int len= arr.size();
//		System.out.println(len);
		arr.add(1, "김정은");
		arr.set(0, "윤강수");
		arr.remove(0);
		for(int k=0; k<arr.size(); k++) {
			System.out.println(arr.get(k));
		}
		
		ArrayList<Integer> in= new ArrayList<>();
		in.add(10);
		in.add(20);
		in.add(30);
		for(int k=0; k<in.size(); k++) {
			System.out.println(in.get(k));
		}
		
//		System.out.println(arr.get(0));
//		System.out.println(arr.get(1));
//		System.out.println(arr.get(2));
//		System.out.println(arr.get(3));

	}

}
