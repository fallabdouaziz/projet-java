package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Roles;
import sn.isi.entities.User;

public interface IAllClass<T> {
	public int add(T t);
	public int update(T t);
	public int delete(int id);
	public List<T> getAll();
	public T get(int id);
	public List<T> getAllUserToles(int id);
}