package sn.isi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import sn.isi.entities.User;

public class LoginDao {
	EntityManager em;
	public LoginDao() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("gestionFormation");
		em=emf.createEntityManager();
	}
	
	public User verification(User user) {
		try {
            return (User)em.createNamedQuery("User.findByEmailAndfindByPassword").setParameter("email", user.getEmail()).setParameter("password", user.getPassword()).getSingleResult();
       } catch (NoResultException e) {
           return null;
       }
	}
	}

