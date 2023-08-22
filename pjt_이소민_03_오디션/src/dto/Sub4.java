package dto;

public class Sub4 {

	private String artist_id, artist_name, artist_gender, total, ave, rank;

	public Sub4(String artist_id, String artist_name, String artist_gender, String total, String ave, String rank) {
		super();
		this.artist_id = artist_id;
		this.artist_name = artist_name;
		this.artist_gender = artist_gender;
		this.total = total;
		this.ave = ave;
		this.rank = rank;
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

	public String getTotal() {
		return total;
	}

	public String getAve() {
		return ave;
	}

	public String getRank() {
		return rank;
	}
	
	
}
