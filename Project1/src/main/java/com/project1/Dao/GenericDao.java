package com.project1.Dao;

import java.util.List;

public interface GenericDao <T> {
	
	List<T> getAll();
	T getByName(String name);
	T queryById(int id);
	void update(T entity);
	void insert(T entity);
	void delete(T entity);

}
