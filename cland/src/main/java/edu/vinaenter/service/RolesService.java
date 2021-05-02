package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.RolesDAO;
import edu.vinaenter.models.Roles;

@Service
public class RolesService implements ICRUDService<edu.vinaenter.models.Roles> {

	@Autowired
	private RolesDAO rolesDAO;
	
	@Override
	public List<edu.vinaenter.models.Roles> getAll() {
		List<Roles> rolesList = rolesDAO.getAll();
		return rolesList;
	}

	@Override
	public int update(edu.vinaenter.models.Roles t) {
		return rolesDAO.update(t);
	}

	@Override
	public int save(edu.vinaenter.models.Roles t) {
		return rolesDAO.save(t);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public edu.vinaenter.models.Roles findOne(edu.vinaenter.models.Roles t) {
		Roles roles = rolesDAO.findOne(t);
		return roles;
	}

	@Override
	public edu.vinaenter.models.Roles findById(int id) {
		Roles roles = rolesDAO.findById(id);
		return roles;
	}

	@Override
	public List<edu.vinaenter.models.Roles> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return null;
	}

}
