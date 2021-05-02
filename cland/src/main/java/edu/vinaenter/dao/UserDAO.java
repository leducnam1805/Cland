package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Roles;
import edu.vinaenter.models.User;

@Repository
public class UserDAO extends AbstractDAO<User> {
	
	private ResultSetExtractor<List<User>> getList(){
		return new ResultSetExtractor<List<User>>() {
			List<User> userList = new ArrayList<User>();
			@Override
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					userList.add(new User(rs.getInt("uId"),
							rs.getString("uName"),
							rs.getString("uFullname"),
							rs.getString("uToken"),
							null,
							new Roles(rs.getInt("uRoleID"),
									rs.getString("rName"))));
				}
				return userList;
			}
		};
		
	}
	
	private RowMapper<User> getRowMapper(){
		return new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User(rs.getInt("uId"),
						rs.getString("uName"),
						rs.getString("uFullname"),
						rs.getString("uToken"),
						rs.getString("uPass"),
						new Roles(rs.getInt("uRoleID"),
								rs.getString("rName")));
				return user;
			}
		};
		
	}
	
	@Override
	public List<User> getAll() {
		final String SQL = "SELECT"
				+ " u.id AS uId,"
				+ " u.username AS uName,"
				+ " u.fullname AS uFullname,"
				+ " u.remember_token AS uToken,"
				+ " u.role_id AS uRoleID,"
				+ " r.name AS rName"
				+ " FROM users AS u"
				+ " INNER JOIN roles AS r ON u.role_id = r.id"
				+ " ORDER BY u.id DESC";
		return jdbcTemplate.query(SQL, getList());
	}
	
	public List<User> getAll(int offset, int rowCount) {
		final String SQL = "SELECT"
				+ " u.id AS uId,"
				+ " u.username AS uName,"
				+ " u.fullname AS uFullname,"
				+ " u.remember_token AS uToken,"
				+ " u.role_id AS uRoleID,"
				+ " r.name AS rName"
				+ " FROM users AS u"
				+ " INNER JOIN roles AS r ON u.role_id = r.id"
				+ " ORDER BY u.id DESC"
				+ " LIMIT ?,?";
		return jdbcTemplate.query(SQL, getList(),offset,rowCount);
	}

	@Override
	public int update(User t) {
		final String SQL = "UPDATE users SET fullname = ?, password = ?, role_id = ? WHERE id = ?";
		return jdbcTemplate.update(SQL, t.getFullname(),t.getPassword(),t.getRole().getId(),t.getId());
	}

	@Override
	public int save(User t) {
		final String SQL = "INSERT INTO users(username,fullname,password,role_id) VALUES(?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getUsername(),t.getFullname(),t.getPassword(),t.getRole().getId());
	}

	@Override
	public int del(int id) {
		final String SQL = "DELETE FROM users WHERE id = ?";
		return jdbcTemplate.update(SQL,id);
	}

	@Override
	public User findOne(User t) {
		return null;
	}

	@Override
	public User findById(int id) {
		final String SQL = "SELECT"
				+ " u.id AS uId,"
				+ " u.username AS uName,"
				+ " u.fullname AS uFullname,"
				+ " u.remember_token AS uToken,"
				+ " u.password AS uPass,"
				+ " u.role_id AS uRoleID,"
				+ " r.name AS rName"
				+ " FROM users AS u"
				+ " INNER JOIN roles AS r ON u.role_id = r.id"
				+ " WHERE u.id = ?";
		return jdbcTemplate.queryForObject(SQL, getRowMapper(), id);
	}

	public int getCountUser() {
		final String SQL = "SELECT COUNT(*) AS countLand FROM users";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}

	public int totalRow() {
		final String SQL = "SELECT COUNT(*)"
				+ " FROM users AS u"
				+ " INNER JOIN roles AS r ON u.role_id = r.id";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}

	public List<User> findByFullname(String fullname,int offset, int totalRow) {
		final String SQL = "SELECT"
				+ " u.id AS uId,"
				+ " u.username AS uName,"
				+ " u.fullname AS uFullname,"
				+ " u.remember_token AS uToken,"
				+ " u.role_id AS uRoleID,"
				+ " r.name AS rName"
				+ " FROM users AS u"
				+ " INNER JOIN roles AS r ON u.role_id = r.id"
				+ " WHERE u.fullname LIKE ?"
				+ " ORDER BY u.id DESC"
				+ " LIMIT ?,?";
		return jdbcTemplate.query(SQL, getList(), "%"+fullname+"%", offset, totalRow);
	}

	public int totalRowByFullname(String fullname) {
		final String SQL = "SELECT COUNT(*)"
				+ " FROM users AS u"
				+ " INNER JOIN roles AS r ON u.role_id = r.id"
				+ " WHERE u.fullname LIKE ?";
		return jdbcTemplate.queryForObject(SQL, Integer.class,"%"+fullname+"%");
	}

	public User findByUsername(String username) {
		final String SQL = "SELECT"
				+ " u.id AS uId,"
				+ " u.username AS uName,"
				+ " u.fullname AS uFullname,"
				+ " u.remember_token AS uToken,"
				+ " u.password AS uPass,"
				+ " u.role_id AS uRoleID,"
				+ " r.name AS rName"
				+ " FROM users AS u"
				+ " INNER JOIN roles AS r ON u.role_id = r.id"
				+ " WHERE u.username LIKE ?";
		return jdbcTemplate.queryForObject(SQL, getRowMapper(), "%"+username+"%");
	}

	public int updateProfile(User t) {
		final String SQL = "UPDATE users SET fullname = ?, password = ?, role_id = ? WHERE id = ?";
		return jdbcTemplate.update(SQL, t.getFullname(),t.getPassword(),t.getRole().getId(),t.getId());
	}
	
}
