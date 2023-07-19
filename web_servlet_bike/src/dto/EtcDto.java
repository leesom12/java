package dto;

public class EtcDto {

	private String no, group_no, title, content, reg_id, reg_name, reg_date, update_date;
	private int depth;
	
	
	
	//수정
	public EtcDto(String no, String title, String content, String update_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.update_date = update_date;
	}

	//뷰
	public EtcDto(String no, String group_no, String title, String content, String reg_id, String reg_name,
			String reg_date, String update_date, int depth) {
		super();
		this.no = no;
		this.group_no = group_no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.depth = depth;
	}

	//이전글, 다음글
	public EtcDto(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}

	//댓글뷰
	public EtcDto(String no, String group_no, String title, String content, String reg_id, String reg_name,
			String reg_date, int depth) {
		super();
		this.no = no;
		this.group_no = group_no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.depth = depth;
	}
	
	//원글 등록
	public EtcDto(String no, String group_no, String title, String content, String reg_id, String reg_date, int depth) {
		super();
		this.no = no;
		this.group_no = group_no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.depth = depth;
	}


	//전체 리스트 조회
	public EtcDto(String no, String title, String reg_id, String reg_name, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.reg_id = reg_id;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
	}
	
	public String getUpdate_date() {
		return update_date;
	}
	public String getNo() {
		return no;
	}
	public String getGroup_no() {
		return group_no;
	}
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}

	public String getReg_id() {
		return reg_id;
	}
	public String getReg_name() {
		return reg_name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public int getDepth() {
		return depth;
	}
	
	
}
