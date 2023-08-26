package dto;

public class Sub3Dto {
	private String player_no, name, point_1, point_2, point_3, point_4, total, ave;

	public Sub3Dto(String player_no, String name, String point_1, String point_2, String point_3, String point_4,
			String total, String ave) {
		super();
		this.player_no = player_no;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public String getPoint_1() {
		return point_1;
	}

	public String getPoint_2() {
		return point_2;
	}

	public String getPoint_3() {
		return point_3;
	}

	public String getPoint_4() {
		return point_4;
	}

	public String getTotal() {
		return total;
	}

	public String getAve() {
		return ave;
	}
	
	
}
