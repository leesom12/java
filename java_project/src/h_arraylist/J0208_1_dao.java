package h_arraylist;

import java.util.ArrayList;

public class J0208_1_dao {
	
	int getKorTotal(ArrayList<J0208_1_dto> dtos) {
		int total=0;
		for(int k=0; k<dtos.size(); k++) {
			total= total+ dtos.get(k).getKor();
		}
		return total;
	}
	
	int getEngTotal(ArrayList<J0208_1_dto> dtos) {
		int total=0;
		for(int k=0; k<dtos.size(); k++) {
			total= total+ dtos.get(k).getEng();
		}
		return total;
	}
	
	int getMatTotal(ArrayList<J0208_1_dto> dtos) {
		int total=0;
		for(int k=0; k<dtos.size(); k++) {
			total= total+ dtos.get(k).getMat();
		}
		return total;
	}
	
	double getKorAve(ArrayList<J0208_1_dto> dtos) {
		int total=0;
		for(int k=0; k<dtos.size(); k++) {
			total= total+ dtos.get(k).getKor();
		}
		double ave= total/(double)dtos.size();
		
		return ave;
	}
	
	double getEngAve(ArrayList<J0208_1_dto> dtos) {
		int total=0;
		for(int k=0; k<dtos.size(); k++) {
			total= total+ dtos.get(k).getEng();
		}
		double ave= total/(double)dtos.size();
		return ave;
	}
	
	double getMatAve(ArrayList<J0208_1_dto> dtos) {
		int total=0;
		for(int k=0; k<dtos.size(); k++) {
			total= total+ dtos.get(k).getMat();
		}
		double ave= total/(double)dtos.size();
		return ave;
	}
	
	void getRank(ArrayList<J0208_1_dto> dtos) {
		ArrayList<Integer> arr= new ArrayList<>();
		int [] rank= new int[arr.size()];
		
		for(int k=0; k<dtos.size(); k++) {
			arr.add(k, dtos.get(k).getTotal());
			rank[k]=1;
		}
		
		for(int k=0; k<arr.size(); k++) {
			for(int i=0; i<arr.size(); i++) {
				if(dtos.get(k).getTotal() < dtos.get(i).getTotal()) rank[k]= rank[k]+1;
			}
		}
		for(int k=0; k<arr.size(); k++) {
			J0208_1_dto dto= new J0208_1_dto();
			dto.setRank(rank[k]);
		}
	}
	
	void setPrint(ArrayList<J0208_1_dto> dtos) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("학년"+"\t"+"반"+"\t"+"번호"+"\t"+"성명"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"총점"+"\t"+"석차");
		System.out.println("---------------------------------------------------------------------");
		
		for(int k=0; k<dtos.size(); k++) {
			System.out.print(dtos.get(k).getGrade()+"학년"+"\t");
			System.out.print(dtos.get(k).getBan()+"반"+"\t");
			System.out.print(dtos.get(k).getBeonho()+"번"+"\t");
			System.out.print(dtos.get(k).getName()+"\t");
			System.out.print(dtos.get(k).getKor()+"점"+"\t");
			System.out.print(dtos.get(k).getEng()+"점"+"\t");
			System.out.print(dtos.get(k).getMat()+"점"+"\t");
			System.out.print(dtos.get(k).getTotal()+"점"+"\t");
			System.out.print(dtos.get(k).getRank()+"\t");
			System.out.print("\n");
		}
		
		System.out.println("---------------------------------------------------------------------");
		System.out.print("총"+dtos.size()+"명"+"\t"+"\t"+"\t"+"\t");
		System.out.print(getKorTotal(dtos)+"점"+"\t");
		System.out.print(getEngTotal(dtos)+"점"+"\t");
		System.out.print(getMatTotal(dtos)+"점"+"\n");
		System.out.print("평균"+"\t"+"\t"+"\t"+"\t");
		System.out.print(Math.round(getKorAve(dtos)*10)/10.0 +"점"+"\t");
		System.out.print(Math.round(getEngAve(dtos)*10)/10.0+"점"+"\t");
		System.out.print(Math.round(getMatAve(dtos)*10)/10.0+"점"+"\t");
		
		
	}

}
