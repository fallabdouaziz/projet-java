package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Roles;
import sn.isi.entities.User;

public interface IRoles {
	public int add(Roles roles);
	public int update(Roles roles);
	public int delete(int id);
	public List<Roles> getAll();
	public Roles get(int id);
	public List<User> getAllUserToles(int id);

}
