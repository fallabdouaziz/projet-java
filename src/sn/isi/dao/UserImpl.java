package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import sn.isi.entities.User;

public class UserImpl implements IUser{
	
EntityManager em;

	
	public UserImpl() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("gestionFormation");
		em=emf.createEntityManager();
		
	}

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(User user) {
		try {
			em.getTransaction().begin();
			em.merge(user);
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
			em.remove(em.find(User.class, id));;
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return (List<User>)em.createQuery("select u from User u").getResultList();
	}

	@Override
	public User get(int id) {
		return (User)em.createNamedQuery("User.findById").setParameter("id", id).getSingleResult();
	}

	@Override
	public User verification(String email, String password) {
		// TODO Auto-generated method stub
		try {
            return (User)em.createNamedQuery("User.findByEmailAndfindByPassword").setParameter("email",email).setParameter("password", password).getSingleResult();
       } catch (NoResultException e) {
           return null;
       }
	}
	
	


}
