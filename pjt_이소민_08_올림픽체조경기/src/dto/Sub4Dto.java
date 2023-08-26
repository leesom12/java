package dto;

public class Sub4Dto {
	private String rnum, player_no, name, nation_name, skill_name, total, ave;

	public Sub4Dto(String rnum, String player_no, String name, String nation_name, String skill_name, String total,
			String ave) {
		super();
		this.rnum = rnum;
		this.player_no = player_no;
		this.name = name;
		this.nation_name = nation_name;
		this.skill_name = skill_name;
		this.total = total;
		this.ave = ave;
	}

	public String getRnum() {
		return rnum;
	}

	public String getPlayer_no() {
		return player_no;
	}

	public String getName() {
		return name;
	}

	public String getNation_name() {
		return nation_name;
	}

	public String getSkill_name() {
		return skill_name;
	}

	public String getTotal() {
		return total;
	}

	public String getAve() {
		return ave;
	}
	
	
}
