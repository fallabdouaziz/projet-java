package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import sn.isi.entities.Roles;
import sn.isi.entities.User;

public class RolesImpl implements IRoles{
EntityManager em;

	
	public RolesImpl() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("gestionFormation");
		em=emf.createEntityManager();
		
	}

	@Override
	public int add(Roles roles) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(roles);
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Roles roles) {
		try {
			em.getTransaction().begin();
			em.merge(roles);
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
			em.remove(em.find(Roles.class, id));;
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Roles> getAll() {
		// TODO Auto-generated method stub
		return (List<Roles>)em.createNamedQuery("Roles.findAll").getResultList();
	}

	@Override
	public Roles get(int id) {
		try {
		return (Roles)em.createNamedQuery("Roles.findById").setParameter("id", id).getSingleResult();
		}catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<User> getAllUserToles(int id) {
		return (List<User>)em.createQuery("SELECT r.users FROM Roles r WHERE r.id=:id").setParameter("id", id).getResultList();
	}

}
