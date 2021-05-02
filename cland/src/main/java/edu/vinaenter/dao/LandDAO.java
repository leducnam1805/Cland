package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Category;
import edu.vinaenter.models.Land;

@Repository
public class LandDAO extends AbstractDAO<Land> {

	// getRowMapper
	private org.springframework.jdbc.core.RowMapper<Land> getRowMapper() {
		return new org.springframework.jdbc.core.RowMapper<Land>() {

			@Override
			public Land mapRow(ResultSet rs, int rowNum) throws SQLException {
				Land land = new Land(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
						rs.getTimestamp("dateCreate"), new Category(rs.getInt("cid"), rs.getString("cname")),
						rs.getString("picture"), rs.getInt("area"), rs.getString("address"), rs.getInt("countViews"));
				return land;
			}
		};
	}

	// getGroupByID
	private ResultSetExtractor<List<Land>> getGroupByCid() {
		return new ResultSetExtractor<List<Land>>() {
			List<Land> landList = new ArrayList<Land>();

			@Override
			public List<Land> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					landList.add(new Land(rs.getInt("countCid"), rs.getString("lname"), rs.getString("description"),
							rs.getTimestamp("dateCreate"), new Category(rs.getInt("catId"), rs.getString("cname")),
							rs.getString("picture"), rs.getInt("area"), rs.getString("address"),
							rs.getInt("countViews")));
				}
				return landList;
			}
		};
	}

	// getList
	private ResultSetExtractor<List<Land>> getList() {
		return new ResultSetExtractor<List<Land>>() {
			List<Land> landList = new ArrayList<Land>();

			@Override
			public List<Land> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					landList.add(new Land(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
							rs.getTimestamp("dateCreate"), new Category(rs.getInt("catId"), rs.getString("cname")),
							rs.getString("picture"), rs.getInt("area"), rs.getString("address"),
							rs.getInt("countViews")));
				}
				return landList;
			}
		};
	}

	@Override
	public List<Land> getAll(int offset, int rowCount) {
		final String SQL = "SELECT lid," + " lname," + " description," + " date_create AS dateCreate," + " l.cid,"
				+ " cname," + " c.cid AS catId," + " picture," + " area," + " address," + " count_views AS countViews"
				+ " FROM lands AS l" + " INNER JOIN categories c" + " ON c.cid = l.cid" + " ORDER BY lid DESC"
				+ " LIMIT ?,?";
		return jdbcTemplate.query(SQL, getList(), offset, rowCount);
	}

	public int totalRow() {
		final String SQL = "SELECT COUNT(*) totalRow" + " FROM lands AS l" + " INNER JOIN categories c"
				+ " ON c.cid = l.cid";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}

	@Override
	public int save(Land t) {
		final String SQL = "INSERT INTO lands (lname,description,picture,cid,address,area) VALUES(?,?,?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getLname(), t.getDescription(), t.getPicture(), t.getCat().getCid(),
				t.getAddress(), t.getArea());
	}

	@Override
	public Land findById(int id) {
		final String SQL = "SELECT lid," + " lname," + " description," + " date_create AS dateCreate," + " l.cid,"
				+ " cname," + " c.cid AS catId," + " picture," + " area," + " address," + " count_views AS countViews"
				+ " FROM lands AS l" + " INNER JOIN categories c" + " ON c.cid = l.cid" + " WHERE lid = ?";
		return jdbcTemplate.queryForObject(SQL, getRowMapper(), id);
	}

	@Override
	public int del(int id) {
		final String SQL = "DELETE FROM lands WHERE lid = ?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public int update(Land t) {
		final String SQL = "UPDATE lands SET lname = ?," + " description = ?," + " cid = ?," + " picture = ?,"
				+ " area = ?," + " address = ?" + " WHERE lid = ?";
		return jdbcTemplate.update(SQL, t.getLname(), t.getDescription(), t.getCat().getCid(), t.getPicture(),
				t.getArea(), t.getAddress(), t.getLid());
	}

	public List<Land> groupByCid() {
		final String SQL = "SELECT lid," + " lname," + " description," + " date_create AS dateCreate,"
				+ " COUNT(l.cid) AS countCid," + " picture," + " area," + " address," + " count_views AS countViews,"
				+ " cname," + " c.cid AS catId" + " FROM lands AS l" + " INNER JOIN categories AS c ON l.cid = c.cid"
				+ " GROUP BY l.cid";
		return jdbcTemplate.query(SQL, getGroupByCid());
	}

	public List<Land> countViews() {
		final String SQL = "SELECT lid," + " lname," + " description," + " date_create AS dateCreate," + " picture,"
				+ " area," + " address," + " count_views AS countViews," + " cname," + " c.cid AS catId"
				+ " FROM lands AS l" + " INNER JOIN categories AS c ON l.cid = c.cid" + " ORDER BY countViews DESC"
				+ " LIMIT 5";
		return jdbcTemplate.query(SQL, getList());
	}

	public List<Land> countViewsCat() {
		final String SQL = "SELECT lid," + " lname," + " description," + " date_create AS dateCreate,"
				+ " COUNT(l.cid) AS countCid," + " picture," + " area," + " address," + " count_views AS countViews,"
				+ " cname," + " c.cid AS catId" + " FROM lands AS l" + " INNER JOIN categories AS c ON l.cid = c.cid"
				+ " GROUP BY l.cid" + " LIMIT 4";
		return jdbcTemplate.query(SQL, getGroupByCid());
	}

	public List<Land> findland(int cid, int lid) {
		final String SQL = "SELECT lid," + " lname," + " description," + " date_create AS dateCreate," + " l.cid,"
				+ " cname," + " c.cid AS catId," + " picture," + " area," + " address," + " count_views AS countViews"
				+ " FROM lands AS l" + " INNER JOIN categories c" + " ON c.cid = l.cid"
				+ " WHERE l.cid = ? AND lid != ?" + " ORDER BY lid DESC";
		return jdbcTemplate.query(SQL, getList(), cid, lid);
	}

	public List<Land> findAll() {
		final String SQL = "SELECT lid," + " lname," + " description," + " date_create AS dateCreate," + " l.cid,"
				+ " cname," + " c.cid AS catId," + " picture," + " area," + " address," + " count_views AS countViews"
				+ " FROM lands AS l" + " INNER JOIN categories c" + " ON c.cid = l.cid" + " ORDER BY lid DESC";
		return jdbcTemplate.query(SQL, getList());
	}

	public List<Land> getLandCat(int id) {
		final String SQL = "SELECT lid," + " lname," + " description," + " date_create AS dateCreate," + " l.cid,"
				+ " cname," + " c.cid AS catId," + " picture," + " area," + " address," + " count_views AS countViews"
				+ " FROM lands AS l" + " INNER JOIN categories c" + " ON c.cid = l.cid" + " WHERE l.cid = ?"
				+ " ORDER BY lid DESC";
		return jdbcTemplate.query(SQL, getList(), id);
	}

	public int getCountLand() {
		final String SQL = "SELECT COUNT(*) AS countLand FROM lands";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}

	public int increaseViews(int id) {
		final String SQL = "UPDATE lands SET count_views = count_views + 1 WHERE lid = ?";
		return jdbcTemplate.update(SQL, id);
	}

	public List<Land> searchLName(int offset, int totalRow, String searchLName) {
		final String SQL = "SELECT lid," + " lname," + " description," + " date_create AS dateCreate," + " l.cid,"
				+ " cname," + " c.cid AS catId," + " picture," + " area," + " address," + " count_views AS countViews"
				+ " FROM lands AS l" + " INNER JOIN categories c" + " ON c.cid = l.cid" + " WHERE lname LIKE ?"
				+ " ORDER BY lid DESC" + " LIMIT ?,?";
		return jdbcTemplate.query(SQL, getList(), "%" + searchLName + "%", offset, totalRow);
	}

	public List<Land> findBylname(String search, int offset, int totalRow) {
		final String SQL = "SELECT lid," + " lname," + " description," + " date_create AS dateCreate," + " l.cid,"
				+ " cname," + " c.cid AS catId," + " picture," + " area," + " address," + " count_views AS countViews"
				+ " FROM lands AS l" + " INNER JOIN categories c" + " ON c.cid = l.cid" + " WHERE lname LIKE ?"
				+ " ORDER BY lid DESC" + " LIMIT ?,?";
		return jdbcTemplate.query(SQL, getList(), "%" + search + "%", offset, totalRow);
	}

	public int totalRowByLname(String search) {
		final String SQL = "SELECT COUNT(*) totalRow" 
				+ " FROM lands AS l" 
				+ " INNER JOIN categories c"
				+ " ON c.cid = l.cid"
				+ " WHERE l.lname LIKE ?";
		return jdbcTemplate.queryForObject(SQL, Integer.class,"%"+search+"%");
	}

}
