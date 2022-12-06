package pos;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void regist(RegisterRequest req) throws Exception {
		Member member = memberDao.selectById(req.getId());

		if (member != null) {
			throw new Exception("DuplicateMemberException");
		}

		Member newMember = new Member(req.getId(), req.getPwd());
		memberDao.insert(newMember);
	}
}