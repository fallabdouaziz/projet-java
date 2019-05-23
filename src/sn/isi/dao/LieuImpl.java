package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Lieu;

public class LieuImpl implements ILieu{

EntityManager em;

	
	public LieuImpl() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("gestionFormation");
		em=emf.createEntityManager();
		
	}

	@Override
	public int add(Lieu lieu) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(lieu);
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Lieu lieu) {
		try {
			em.getTransaction().begin();
			em.merge(lieu);
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Lieu.class, id));;
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Lieu> getAll() {
		// TODO Auto-generated method stub
		return (List<Lieu>)em.createQuery("select u from Lieu u").getResultList();
	}

	@Override
	public Lieu get(int id) {
		return (Lieu)em.createNamedQuery("Lieu.findById").setParameter("id", id).getSingleResult();
	}

}
