package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Formation;

public class FormationImpl implements IFormation{
EntityManager em;

	
	public FormationImpl() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("gestionFormation");
		em=emf.createEntityManager();
		
	}

	@Override
	public int add(Formation formation) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(formation);
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Formation formation) {
		try {
			em.getTransaction().begin();
			em.merge(formation);
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
			em.remove(em.find(Formation.class, id));;
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Formation> getAll() {
		// TODO Auto-generated method stub
		return (List<Formation>)em.createQuery("select u from Formation u").getResultList();
	}

	@Override
	public Formation get(int id) {
		return (Formation)em.createNamedQuery("Formation.findById").setParameter("id", id).getSingleResult();
	}

}
