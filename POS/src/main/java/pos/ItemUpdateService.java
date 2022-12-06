package pos;

public class ItemUpdateService {
	private ItemDao itemDao;

	public ItemUpdateService(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void update(UpdateRequest req) throws Exception {
		Item item = itemDao.selectById(req.getId());

		if (item == null) {
			throw new Exception("NoItemException");
		}

		itemDao.update(req);
	}
}