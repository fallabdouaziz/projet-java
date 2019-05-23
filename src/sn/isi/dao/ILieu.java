package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Lieu;

public interface ILieu {
	public int add(Lieu lieu);
	public int update(Lieu lieu);
	public int delete(int id);
	public List<Lieu> getAll();
	public Lieu get(int id);

}
