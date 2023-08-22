package dto;

public class AuditionDto {
	private String artist_id, artist_name, artist_gender, artist_birth, talent, agency, mento_id, mento_name, grade, rnum, ave_point;
	private int serial_no, mento_point, total_point;
	
	
	//등수조회
	public AuditionDto(String artist_id, String artist_name, String artist_gender, String rnum, int total_point, String ave_point) {
		super();
		this.artist_id = artist_id;
		this.artist_name = artist_name;
		this.artist_gender = artist_gender;
		this.rnum = rnum;
		this.total_point = total_point;
		this.ave_point = ave_point;
	}

	
	//멘토점수조회
	public AuditionDto(String artist_id, String artist_name, String artist_birth, String mento_id, String mento_name,
			String grade, int serial_no, int mento_point) {
		super();
		this.artist_id = artist_id;
		this.artist_name = artist_name;
		this.artist_birth = artist_birth;
		this.mento_id = mento_id;
		this.mento_name = mento_name;
		this.grade = grade;
		this.serial_no = serial_no;
		this.mento_point = mento_point;
	}

	//참가자선택
	public AuditionDto(String artist_id) {
		super();
		this.artist_id = artist_id;
	}

	//오디션등록
	public AuditionDto(String artist_id, String artist_name, String artist_gender, String artist_birth, String talent,
			String agency) {
		super();
		this.artist_id = artist_id;
		this.artist_name = artist_name;
		this.artist_gender = artist_gender;
		this.artist_birth = artist_birth;
		this.talent = talent;
		this.agency = agency;
	}
	

	public String getGrade() {
		return grade;
	}

	public String getRnum() {
		return rnum;
	}

	public String getArtist_id() {
		return artist_id;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public String getArtist_gender() {
		return artist_gender;
	}
	public String getArtist_birth() {
		return artist_birth;
	}
	public String getTalent() {
		return talent;
	}
	public String getAgency() {
		return agency;
	}
	public String getMento_id() {
		return mento_id;
	}
	public String getMento_name() {
		return mento_name;
	}
	public int getSerial_no() {
		return serial_no;
	}
	public int getMento_point() {
		return mento_point;
	}
	public int getTotal_point() {
		return total_point;
	}
	public String getAve_point() {
		return ave_point;
	}
	
	
}
