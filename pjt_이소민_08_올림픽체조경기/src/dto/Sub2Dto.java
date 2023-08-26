package dto;

public class Sub2Dto {
	private String player_no;
	private int point_1, point_2, point_3, point_4, total;
	private double ave;
	
	public Sub2Dto(String player_no, int point_1, int point_2, int point_3, int point_4, int total, double ave) {
		super();
		this.player_no = player_no;
		this.point_1 = point_1;
		this.point_2 = point_2;
		this.point_3 = point_3;
		this.point_4 = point_4;
		this.total = total;
		this.ave = ave;
	}
	

	public String getPlayer_no() {
		return player_no;
	}
	public int getPoint_1() {
		return point_1;
	}
	public int getPoint_2() {
		return point_2;
	}
	public int getPoint_3() {
		return point_3;
	}
	public int getPoint_4() {
		return point_4;
	}
	public int getTotal() {
		return total;
	}
	public double getAve() {
		return ave;
	} 
	
	
	
}
