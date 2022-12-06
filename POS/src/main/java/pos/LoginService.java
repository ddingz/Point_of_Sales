package pos;

public class LoginService {
	private MemberDao memberDao;
	private boolean session = false;

	public boolean isSession() {
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}

	public LoginService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void login(LoginRequest req) {
		Member member = memberDao.selectById(req.getId());

		if (member != null && member.getPwd().equals(member.getPwd()))
			this.session = true;
		else
			this.session = false;
	}
}