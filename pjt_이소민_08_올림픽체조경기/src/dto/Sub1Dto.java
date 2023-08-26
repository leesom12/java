package dto;

public class Sub1Dto {
	private String player_no, name, gender, birth, skill_name, nation_name;

	public Sub1Dto(String player_no, String name, String gender, String birth, String skill_name, String nation_name) {
		super();
		this.player_no = player_no;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.skill_name = skill_name;
		this.nation_name = nation_name;
	}

	public String getPlayer_no() {
		return player_no;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getBirth() {
		return birth;
	}

	public String getSkill_name() {
		return skill_name;
	}

	public String getNation_name() {
		return nation_name;
	}
	
	
}
