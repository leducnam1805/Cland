package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.LandDAO;
import edu.vinaenter.models.Land;

@Service
public class LandService implements ICRUDService<Land> {

	@Autowired
	private LandDAO landDAO;

	@Override
	public List<Land> getAll(int offset, int rowCount) {
		return landDAO.getAll(offset, rowCount);
	}

	@Override
	public List<Land> getAll() {
		List<Land> landList = landDAO.findAll();
		return landList;
	}

	@Override
	public int update(Land t) {
		return landDAO.update(t);
	}

	@Override
	public int save(Land land) {
		return landDAO.save(land);
	}

	@Override
	public int del(int id) {
		return landDAO.del(id);
	}

	@Override
	public Land findOne(Land t) {
		return null;
	}

	@Override
	public Land findById(int id) {
		return landDAO.findById(id);
	}

	public int totalRow() {
		return landDAO.totalRow();
	}

	public List<Land> groupByCid() {
		List<Land> groupByCid = landDAO.groupByCid();
		return groupByCid;
	}

	public List<Land> getCountViews() {
		List<Land> CountViewList = landDAO.countViews();
		return CountViewList;
	}

	public List<Land> getCountViewCat() {
		List<Land> CountViewList = landDAO.countViewsCat();
		return CountViewList;
	}

	public List<Land> findLand(int cid, int lid) {
		List<Land> findLandList = landDAO.findland(cid,lid);
		return findLandList;
	}

	public List<Land> getLandCat(int id) {
		List<Land> getLandCatList = landDAO.getLandCat(id);
		return getLandCatList;
	}

	public int getCountLand() {
		return landDAO.getCountLand();
	}

	public int increaseViews(int id) {
		return landDAO.increaseViews(id);
	}

	public List<Land> findBylname(String search, int offset, int totalRow) {
		return landDAO.findBylname(search,offset,totalRow);
	}

	public int totalRowByLname(String search) {
		return landDAO.totalRowByLname(search);
	}

}
