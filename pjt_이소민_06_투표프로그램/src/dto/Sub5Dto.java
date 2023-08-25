package dto;

public class Sub5Dto {
	private String m_no, m_name, v_count, percent;

	public Sub5Dto(String m_no, String m_name, String v_count, String percent) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.v_count = v_count;
		this.percent = percent;
	}

	public String getM_no() {
		return m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public String getV_count() {
		return v_count;
	}

	public String getPercent() {
		return percent;
	}
	
	
}
