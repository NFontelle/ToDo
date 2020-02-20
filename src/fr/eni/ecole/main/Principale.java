package fr.eni.ecole.main;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.eni.ecole.bean.Utilisateurs;

public class Principale {

	public static void main(String[] args) {
		
		
		
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ListeToDo");//nom du persistence.xml dans la def du persitence unit
		EntityManager em =emf.createEntityManager();
		
		Utilisateurs u = new Utilisateurs();
		u.setIdentifiant("toto");
		u.setMotDePasse("Leponge");
	
		EntityTransaction tr = em.getTransaction();
		tr.begin();//debut de la transaction
		try {
			em.persist(u);
			tr.commit();//validation de la transaction
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();//si echec, rollback, remis à zero
		}
	
	
		em.close();
		emf.close();
	}

}
