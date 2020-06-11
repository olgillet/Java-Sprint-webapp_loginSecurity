package com.app.dao;

import java.util.List;

public interface GenericDao<K, T> {
	public List<T> findAll();
	public T findOne(K id);
	public T create(T entity);
	public T update(T entity);
	public void deleteById(K id);
	public void delete(T entity);
}
