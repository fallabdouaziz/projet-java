package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Formation;

public interface IFormation {
	public int add(Formation formation);
	public int update(Formation formation);
	public int delete(int id);
	public List<Formation> getAll();
	public Formation get(int id);
}
