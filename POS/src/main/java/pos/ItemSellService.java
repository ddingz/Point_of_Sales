package pos;

public class ItemSellService {
	private ItemDao itemDao;

	public ItemSellService(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public boolean sell(UpdateRequest req) throws Exception {
		Item item = itemDao.selectById(req.getId());

		if (item == null) {
			throw new Exception("NoItemException");
		}

		if (item.getQuantity() < req.getQuantity())
			return false;

		int temp = req.getQuantity();

		req.setQuantity(item.getQuantity() - req.getQuantity());
		itemDao.update(req);

		item.setQuantity(temp);
		itemDao.sold(item);

		req.setQuantity(temp);

		return true;
	}

	public int total(UpdateRequest req) {
		int total;

		Item item = itemDao.selectById(req.getId());
		total = item.getPrice() * req.getQuantity();

		return total;
	}
}