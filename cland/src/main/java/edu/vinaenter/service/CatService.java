package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.CategoryDAO;
import edu.vinaenter.models.Category;

@Service
public class CatService implements ICRUDService<Category>{
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Category> getAll() {
		List<Category> catList = categoryDAO.getAll();
		return catList;
	}

	@Override
	public int update(Category t) {
		return categoryDAO.update(t);
	}

	@Override
	public int save(Category t) {
		return categoryDAO.save(t);
	}

	@Override
	public int del(int id) {
		return categoryDAO.del(id);
	}

	@Override
	public Category findOne(Category t) {
		return null;
	}

	@Override
	public Category findById(int id) {
		Category category = categoryDAO.findById(id);
		return category;
	}

	@Override
	public List<Category> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCountCat() {
		return categoryDAO.getCountCat();
	}

}
