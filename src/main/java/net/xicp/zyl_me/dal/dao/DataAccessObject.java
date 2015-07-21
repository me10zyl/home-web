package net.xicp.zyl_me.dal.dao;

import java.util.List;

public abstract class DataAccessObject<T> {
	public abstract T findById(int id);
	public abstract List<T> list();
	public abstract void delete(T t);
	public abstract void update(T t);
	public abstract void save(T t);
}