package edu.vinaenter.service;

import java.util.List;

public interface ICRUDService<T> {
	
	//mặc định của nó là public
	// T viết tắt cảu type
	//Gerneric
	//commond
	List<T> getAll();
	
	int update(T t);
	
	int save(T t);
	
	int del(int id);
	
	T findOne(T t);
	
	T findById(int id);

	List<T> getAll(int offset, int rowCount);
	
}
