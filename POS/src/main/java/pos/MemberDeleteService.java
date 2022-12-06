package pos;

public class MemberDeleteService {
	private MemberDao memberDao;

	public MemberDeleteService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public boolean delete(LoginRequest req) throws Exception {
		Member member = memberDao.selectById(req.getId());

		if (member == null) {
			throw new Exception("NoMemberException");
		}

		if (!member.getPwd().equals(req.getPwd()))
			return false;

		memberDao.delete(member);

		return true;
	}
}