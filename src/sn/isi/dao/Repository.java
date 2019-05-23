package sn.isi.dao;

import java.util.List;

public interface Repository<T> {
	public int add(T t);
	public int update(T t);
	public int delete(int id);
	public List<T> getAll();
	public T get(int id);
}
