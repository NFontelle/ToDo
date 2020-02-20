package fr.eni.ecole.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOUtil {

	public DAOUtil() {
		emf = Persistence.createEntityManagerFactory("ListeToDo");
		em = emf.createEntityManager();
	}
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public EntityManager getEntityManager(){
		return em;
	}
	
	public void close(){
		emf.close();
	}
	
	
}
