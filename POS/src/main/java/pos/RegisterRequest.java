package pos;

public class RegisterRequest {
	private String id;
	private long pwd;
	private long confirmPwd;

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

	public long getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(long confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public boolean isPasswordEqualToConfirmPassword() {
		return pwd == confirmPwd ? true : false;
	}
}