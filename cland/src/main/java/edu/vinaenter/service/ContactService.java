package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.ContactDAO;
import edu.vinaenter.models.Contact;

@Service
public class ContactService implements ICRUDService<Contact> {

	@Autowired
	private ContactDAO contactDAO;

	@Override
	public List<Contact> getAll(int offset, int rowCount) {
		return contactDAO.getAll(offset, rowCount);
	}

	@Override
	public List<Contact> getAll() {
		List<Contact> contactList = contactDAO.getAll();
		return contactList;
	}

	@Override
	public int update(Contact t) {
		return 0;
	}

	@Override
	public int save(Contact t) {
		return contactDAO.save(t);
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
		return contactDAO.totalRow();
	}

	public List<Contact> findByFullname(String search, int offset, int totalRow) {
		return contactDAO.findByFullname(search,offset,totalRow);
	}

	public int totalRowByFullname(String search) {
		return contactDAO.totalRowByFullname(search);
	}

}
