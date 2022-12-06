package pos;

public class LoginRequest {
	private String id;
	private long pwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getPwd() {
		return pwd;
	}

	public void setPwd(long pwd) {
		this.pwd = pwd;
	}
}