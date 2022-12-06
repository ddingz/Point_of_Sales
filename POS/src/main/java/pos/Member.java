package pos;

public class Member {
	private String id;
	private Long pwd;

	public Member(String id, long pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getPwd() {
		return pwd;
	}

	public void setPwd(Long pwd) {
		this.pwd = pwd;
	}
}