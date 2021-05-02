package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Contact;

@Repository
public class ContactDAO extends AbstractDAO<Contact> {

	private ResultSetExtractor<List<Contact>> getList() {

		return new ResultSetExtractor<List<Contact>>() {
			List<Contact> contactList = new ArrayList<Contact>();

			@Override
			public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					contactList.add(new Contact(rs.getInt("cid"), rs.getString("fullname"), rs.getString("email"),
							rs.getString("subject"), rs.getString("content")));
				}
				return contactList;
			}
		};
	}

	@Override
	public List<Contact> getAll(int offset, int rowCount) {
		final String SQL = "SELECT cid," 
				+ " fullname," 
				+ " email," 
				+ " subject," 
				+ " content" 
				+ " FROM vnecontact"
				+ " ORDER BY cid DESC"
				+ " LIMIT ?,?";
		return jdbcTemplate.query(SQL, getList(), offset, rowCount);
	}

	@Override
	public List<Contact> getAll() {
		final String SQL = "SELECT cid," + " fullname," + " email," + " subject," + " content" + " FROM vnecontact";
		return jdbcTemplate.query(SQL, getList());
	}

	@Override
	public int update(Contact t) {
		return 0;
	}

	@Override
	public int save(Contact t) {
		final String SQL = "INSERT INTO vnecontact(fullname,email,subject,content) VALUES(?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getFullname(), t.getEmail(), t.getSubject(), t.getContent());
	}

	@Override
	public int del(int id) {
		return 0;
	}

	@Override
	public Contact findOne(Contact t) {
		return null;
	}

	@Override
	public Contact findById(int id) {
		return null;
	}
	
	public int totalRow() {
		final String SQL = "SELECT COUNT(*) totalRow"
				+ " FROM vnecontact";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}

	public List<Contact> findByFullname(String search, int offset, int totalRow) {
		final String SQL = "SELECT cid," 
				+ " fullname," 
				+ " email," 
				+ " subject," 
				+ " content" 
				+ " FROM vnecontact"
				+ " WHERE fullname LIKE ?"
				+ " ORDER BY cid DESC"
				+ " LIMIT ?,?";
		return jdbcTemplate.query(SQL, getList(), "%"+search+"%",offset,totalRow);
	}

	public int totalRowByFullname(String search) {
		final String SQL = "SELECT COUNT(*) totalRow"
				+ " FROM vnecontact"
				+ " WHERE fullname LIKE ?";
		return jdbcTemplate.queryForObject(SQL, Integer.class,"%"+search+"%");
	}

}
