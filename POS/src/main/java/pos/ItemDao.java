package pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

public class ItemDao {
	private JdbcTemplate jdbcTemplate;

	public ItemDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Item> selectAll() {
		List<Item> results = jdbcTemplate.query("select * from ITEM", (ResultSet rs, int rowNum) -> {
			Item item = new Item(rs.getString("name"), rs.getInt("quantity"), rs.getInt("price"));
			item.setId(rs.getInt("id"));

			return item;
		});

		return results;
	}

	public Item selectById(int id) {
		List<Item> results = jdbcTemplate.query("select * from ITEM where id = ?", new RowMapper<Item>() {
			@Override
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				Item item = new Item(rs.getString("name"), rs.getInt("quantity"), rs.getInt("price"));
				item.setId(rs.getInt("id"));

				return item;
			}
		}, id);

		return results.isEmpty() ? null : results.get(0);
	}

	public void update(UpdateRequest item) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("update ITEM set quantity = ? where id = ?");
				pstmt.setInt(1, item.getQuantity());
				pstmt.setInt(2, item.getId());

				return pstmt;
			}
		});
	}

	public void sold(Item item) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con
						.prepareStatement("insert into SOLD (id, name, quantity, price, date) values (?, ?, ?, ?, ?)");
				pstmt.setInt(1, item.getId());
				pstmt.setString(2, item.getName());
				pstmt.setInt(3, item.getQuantity());
				pstmt.setInt(4, item.getPrice());
				pstmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

				return pstmt;
			}
		});
	}

	public List<Item> soldList() {
		List<Item> results = jdbcTemplate.query("select * from SOLD", (ResultSet rs, int rowNum) -> {
			Item item = new Item(rs.getString("name"), rs.getInt("quantity"), rs.getInt("price"),
					rs.getTimestamp("date").toLocalDateTime());
			item.setId(rs.getInt("id"));

			return item;
		});

		return results;
	}
}