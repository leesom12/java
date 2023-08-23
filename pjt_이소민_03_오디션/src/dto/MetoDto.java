package dto;

public class MetoDto {
	private String artist_id, mento_id, point;
	private int serial_no;
	
	
	
	
	public MetoDto(String artist_id, String mento_id, int serial_no, String point) {
		super();
		this.artist_id = artist_id;
		this.mento_id = mento_id;
		this.serial_no = serial_no;
		this.point = point;
	}
	public String getArtist_id() {
		return artist_id;
	}
	public String getMento_id() {
		return mento_id;
	}
	public int getSerial_no() {
		return serial_no;
	}
	public String getPoint() {
		return point;
	}
	
	
	
	
	
}
