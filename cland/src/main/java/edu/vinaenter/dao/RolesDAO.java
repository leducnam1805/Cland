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

@Repository
public class RolesDAO extends AbstractDAO<Roles>{
	
	private ResultSetExtractor<List<Roles>> getList(){
		return new ResultSetExtractor<List<Roles>>() {
			List<Roles> rolesList = new ArrayList<Roles>();
			@Override
			public List<Roles> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					rolesList.add(new Roles(rs.getInt("rid"), rs.getString("rname")));
				}
				return rolesList;
			}
		};
		
	}
	
	private RowMapper<Roles> getRowMapper(){
		return new RowMapper<Roles>() {
			@Override
			public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
				Roles roles = new Roles(rs.getInt("rid"), rs.getString("rname"));
				return roles;
			}
		};
	}
	
	@Override
	public List<edu.vinaenter.models.Roles> getAll() {
		final String SQL = "SELECT r.id AS rid,"
				+ " r.name AS rname"
				+ " FROM roles AS r"
				+ " ORDER BY rid DESC";
		return jdbcTemplate.query(SQL, getList());
	}

	@Override
	public int update(edu.vinaenter.models.Roles t) {
		final String SQL = "UPDATE roles SET name = ? WHERE id = ?";
		return jdbcTemplate.update(SQL, t.getName(),t.getId());
	}

	@Override
	public int save(edu.vinaenter.models.Roles t) {
		final String SQL = "INSERT INTO roles(name) VALUE(?)";
		return jdbcTemplate.update(SQL, t.getName());
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public edu.vinaenter.models.Roles findOne(edu.vinaenter.models.Roles t) {
		final String SQL = "SELECT r.id AS rid,"
				+ " r.name AS rname"
				+ " FROM roles AS r"
				+ " WHERE r.name LIKE ?";
		return jdbcTemplate.queryForObject(SQL, getRowMapper(), "%"+t.getName()+"%");
	}

	@Override
	public edu.vinaenter.models.Roles findById(int id) {
		final String SQL = "SELECT r.id AS rid,"
				+ " r.name AS rname"
				+ " FROM roles AS r"
				+ " WHERE r.id = ?";
		return jdbcTemplate.queryForObject(SQL, getRowMapper(),id);
	}

	@Override
	public List<edu.vinaenter.models.Roles> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return null;
	}

}
