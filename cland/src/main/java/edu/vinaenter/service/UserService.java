package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.UserDAO;
import edu.vinaenter.models.User;

@Service
public class UserService implements ICRUDService<User> {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> getAll() {
		List<User> userList = userDAO.getAll();
		return userList;
	}

	@Override
	public int update(User t) {
		return userDAO.update(t);
	}

	@Override
	public int save(User t) {
		return userDAO.save(t);
	}

	@Override
	public int del(int id) {
		return userDAO.del(id);
	}

	@Override
	public User findOne(User t) {
		return null;
	}

	@Override
	public User findById(int id) {
		return userDAO.findById(id);
	}

	@Override
	public List<User> getAll(int offset, int rowCount) {
		return userDAO.getAll(offset, rowCount);
	}

	public int getCountUser() {
		return userDAO.getCountUser();
	}

	public int totalRow() {
		return userDAO.totalRow();
	}

	public List<User> findByFullname(String fullname, int offset, int totalRow) {
		return userDAO.findByFullname(fullname,offset,totalRow);
	}

	public int totalRowByFullname(String fullname) {
		return userDAO.totalRowByFullname(fullname);
	}

	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	public int updateProfile(User user) {
		return userDAO.updateProfile(user);
	}

}
