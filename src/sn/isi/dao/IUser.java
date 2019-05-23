package sn.isi.dao;

import java.util.List;

import sn.isi.entities.User;

public interface IUser {
	public int add(User user);
	public int update(User user);
	public int delete(int id);
	public List<User> getAll();
	public User get(int id);
	public User verification(String email,String password);

}
