package p_database;

public class Consulting_이소민_dto {
	String cid, sid, sname, mid, mname, date, content;


	public Consulting_이소민_dto(String cid, String sid, String mid, String date, String content) {
		super();
		this.cid = cid;
		this.sid = sid;
		this.mid = mid;
		this.date = date;
		this.content = content;
	}


	public Consulting_이소민_dto(String cid, String sid, String sname, String mid, String mname, String date,
			String content) {
		super();
		this.cid = cid;
		this.sid = sid;
		this.sname = sname;
		this.mid = mid;
		this.mname = mname;
		this.date = date;
		this.content = content;
	}


	public String getCid() {
		return cid;
	}

	public String getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public String getMid() {
		return mid;
	}

	public String getMname() {
		return mname;
	}

	public String getDate() {
		return date;
	}
	
	public String getContent() {
		return content;
	}





	
}
