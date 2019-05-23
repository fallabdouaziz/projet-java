package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class Repositoryimpl<T> implements Repository<T> {
	EntityManager em;

	public Repositoryimpl() {
		try {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("gestionFormation");
			em=emf.createEntityManager();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public int add(T t) {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(T t) {
		try {
			em.getEntityManagerFactory();
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			return 1;	
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int delete(int id) {
		try {
			em.getEntityManagerFactory();
			em.getTransaction().begin();
			  em.remove(em.createQuery("select u from T where u.id=:id").setParameter("id", id).getSingleResult());
			em.getTransaction().commit();
			return 1;	
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		  return em.createNamedQuery("T.findAll").getResultList();
	}

	@Override
	public T get(int id) {
		try {
			
    		return (T)em.createNamedQuery("T.findById").setParameter("id", id).getSingleResult();
    		
    	} catch (NoResultException e) {
            return null;
        }
	}



	
	
	

}
